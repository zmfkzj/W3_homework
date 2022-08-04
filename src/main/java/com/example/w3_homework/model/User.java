package com.example.w3_homework.model;

import com.example.w3_homework.dto.PassDto;
import com.example.w3_homework.dto.UserDto;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER) //연관관계 맵핑, 현재 양방향 연결되어 있음
    private Set<Comment> commentList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER) //연관관계 맵핑, 현재 양방향 연결되어 있음
    private Set<Post> postList;

    @Builder
    public User(String username, String password, Set<Comment> commentList, Set<Post> postList){
        this.username = username;
        this.password = password;
        this.commentList = commentList;
        this.postList = postList;
    }

    public User(UserDto userDto){
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.commentList = userDto.getCommentList();
        this.postList = userDto.getPostList();
    }

    public void update(PassDto passDto){
        this.password = passDto.getPassword();
    }
}
