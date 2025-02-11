package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.UserRequestDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.dto.UserSignUpRequestDto;
import com.example.scheduledevelop.dto.UserSignUpResponseDto;
import com.example.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    // User 회원가입
    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponseDto> signUp(@RequestBody UserSignUpRequestDto requestDto) {
        UserSignUpResponseDto userSignUpResponseDto =
                userService.signUp(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());
        return new ResponseEntity<>(userSignUpResponseDto, HttpStatus.CREATED);
    }

    // User 전체 조회
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        List<UserResponseDto> userResponseDto = userService.findAll();
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    // User 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    // User 수정
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateById(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        UserResponseDto userResponseDto = userService.updateById(id, requestDto.getUsername(), requestDto.getEmail());
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    // User 삭제
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }



}
