package com.example.scheduledevelop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserSignUpRequestDto {

    @NotBlank(message = "username은 필수값입니다.")
    @Size(min = 3, max = 10, message = "username은 3~10글자입니다.")
    private String username;

    @NotBlank(message = "email은 필수값입니다.")
    @Email(message = "email 형식을 확인하세요.")
    private String email;

    @NotBlank(message = "password는 필수값입니다.")
    @Size(min = 8, max = 20, message = "password는 8~20글자입니다.")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "비밀번호는 최소 8자 이상이며, 영문/숫자/특수문자를 포함해야 합니다."
    )
    private String password;

    public UserSignUpRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
