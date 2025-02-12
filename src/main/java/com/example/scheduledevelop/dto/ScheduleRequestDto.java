package com.example.scheduledevelop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    @NotBlank(message = "username은 필수값입니다.")
    private String username;

    @NotBlank(message = "title은 필수값입니다.")
    @Size(min = 1, max = 10, message = "title 1~10글자입니다.")
    private String title;

    @NotBlank(message = "contents는 필수값입니다.")
    @Size(min = 10, message = "title 최소 10글자입니다.")
    private String contents;

    public ScheduleRequestDto(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}
