package com.example.w3_homework.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class CommentUpdateDto {
    private String content;

    public CommentUpdateDto(String content){
        this.content = content;
    }
}
