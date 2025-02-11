package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private String title;
    private String contents;
    private String username;

    public ScheduleRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}
