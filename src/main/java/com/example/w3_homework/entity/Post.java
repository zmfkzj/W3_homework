package com.example.w3_homework.entity;

import com.example.w3_homework.dto.PostDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String password;

    @Builder
    public Post(String title, String content, String author, String password){
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public Post(PostDto postDto){
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        this.author = postDto.getAuthor();
        this.password = postDto.getPassword();
    }

    public void update(PostDto postDto) {
        this.title = postDto.getTitle();
        this.author = postDto.getAuthor();
        this.content = postDto.getContent();
    }

}
