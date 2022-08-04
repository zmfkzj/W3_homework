package com.example.w3_homework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostContentDto {
    private String content;
    private String title;

    public PostContentDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
