package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private String username;
    private String title;
    private String contents;

    public ScheduleRequestDto(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}
