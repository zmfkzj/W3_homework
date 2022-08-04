package com.example.w3_homework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SignInDto {
    private String username;
    private String password;

    public SignInDto(String username, String password){
        this.password = password;
        this.username = username;
    }

}
