package com.example.w3_homework.model;

import com.example.w3_homework.dto.CommentDto;
import com.example.w3_homework.dto.CommentUpdateDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "comments")
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId")
    private User user;

    @Builder
    public Comment(String content, User user, Post post){
        this.content = content;
        this.user = user;
        this.post = post;
    }

    public Comment(CommentDto commentDto){
        this.content = commentDto.getContent();
        this.user = commentDto.getUser();
        this.post = commentDto.getPost();
    }

    public void update(CommentUpdateDto commentUpdateDto){
        this.content = commentUpdateDto.getContent();
    }
}
