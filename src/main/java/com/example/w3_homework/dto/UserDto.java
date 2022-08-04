package com.example.w3_homework.dto;

import com.example.w3_homework.model.Comment;
import com.example.w3_homework.model.Post;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
public class UserDto {
    private String username;
    private String password;
    private Set<Comment> commentList;
    private Set<Post> postList;
}
