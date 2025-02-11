package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.UserSignUpRequestDto;
import com.example.scheduledevelop.dto.UserSignUpResponseDto;
import com.example.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponseDto> signUp(@RequestBody UserSignUpRequestDto requestDto) {
        UserSignUpResponseDto userSignUpResponseDto =
                userService.signUp(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());
        return new ResponseEntity<>(userSignUpResponseDto, HttpStatus.CREATED);
    }



}
