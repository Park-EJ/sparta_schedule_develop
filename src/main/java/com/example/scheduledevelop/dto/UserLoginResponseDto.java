package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class UserLoginResponseDto {

    private final Long id;
    private final String username;
    private final String email;

    public UserLoginResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
