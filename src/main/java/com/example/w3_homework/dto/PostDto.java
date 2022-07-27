package com.example.w3_homework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostDto {
    private String title;
    private String content;
    private String author;
    private String password;

    public PostDto(String title, String content, String author, String password){
        this.title = title;
        this.author = author;
        this.content = content;
        this.password = password;
    }
}
