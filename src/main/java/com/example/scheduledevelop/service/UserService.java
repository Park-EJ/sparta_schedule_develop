package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.UserLoginResponseDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.dto.UserSignUpResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSignUpResponseDto signUp(@Valid String username, String email, String password) {
        User user = new User(username, email, password);

        User savedUser = userRepository.save(user);

        return new UserSignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAll() {
        List<User> users = userRepository.findAll();

        List<UserResponseDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(new UserResponseDto(user.getId(), user.getUsername(), user.getEmail()));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {
        User findUser = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID가 존재하지 않습니다."));

        return new UserResponseDto(findUser.getId(), findUser.getUsername(), findUser.getEmail());
    }

    @Transactional
    public UserResponseDto updateById(Long id, String username, String email) {
        User findUser = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID가 존재하지 않습니다."));

        findUser.updateById(username, email);

        return new UserResponseDto(findUser.getId(), findUser.getUsername(), findUser.getEmail());
    }

    @Transactional
    public void deleteById(Long id) {
        if(!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID가 존재하지 않습니다.");
        }

        userRepository.deleteById(id);
    }

    @Transactional
    public UserLoginResponseDto login(String email, String password, HttpSession session) {
        User findUser = userRepository.findByEmail(email).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 Email이 존재하지 않습니다."));

        if (!findUser.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "비밀번호가 일치하지 않습니다.");
        }
        session.setAttribute("USER", findUser);

        return new UserLoginResponseDto(findUser.getId(), findUser.getUsername(), findUser.getEmail());
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }
}
