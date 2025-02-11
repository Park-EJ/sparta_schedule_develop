package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {

    private String username;
    private String email;

    public UserRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
