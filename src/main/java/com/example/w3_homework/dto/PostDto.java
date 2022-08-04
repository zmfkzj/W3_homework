package com.example.w3_homework.dto;

import com.example.w3_homework.model.Comment;
import com.example.w3_homework.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
public class PostDto {
    private String title;
    private String content;
    private User user;
    private Set<Comment> commentList;

    public PostDto(String title, String content, User user, Set<Comment> commentList){
        this.title = title;
        this.content = content;
        this.user = user;
        this.commentList = commentList;
    }
}
