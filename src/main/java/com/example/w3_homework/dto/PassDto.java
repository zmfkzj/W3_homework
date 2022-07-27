package com.example.w3_homework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PassDto {
    private String password;

    public PassDto(String password){
        this.password = password;
    }
}
