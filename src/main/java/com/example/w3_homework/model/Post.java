package com.example.w3_homework.model;

import com.example.w3_homework.dto.PostDto;
import com.example.w3_homework.dto.PostContentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER) //연관관계 맵핑, 현재 양방향 연결되어 있음
    private Set<Comment> commentList;

    @Builder
    public Post(String title, String content, User user){
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Post(PostContentDto postContentDto, User user){
        this.title = postContentDto.getTitle();
        this.content = postContentDto.getContent();
        this.user = user;
    }

    public void update(PostContentDto postContentDto) {
        this.title = postContentDto.getTitle();
        this.content = postContentDto.getContent();
    }

}
