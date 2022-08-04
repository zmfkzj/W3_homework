package com.example.w3_homework.dto;

import com.example.w3_homework.model.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDto {
    private String content;
    private User user;
    private Post post;

    public CommentDto(String content, User user, Post post){
        this.content = content;
        this.user = user;
        this.post = post;
    }
}
