package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.UserSignUpResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSignUpResponseDto signUp(String username, String email, String password) {
        User user = new User( username, email, password);

        User savedUser = userRepository.save(user);

        return new UserSignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }
}
