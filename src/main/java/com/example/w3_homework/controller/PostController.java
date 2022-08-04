package com.example.w3_homework.controller;

import com.example.w3_homework.dto.PostDto;
import com.example.w3_homework.dto.PostContentDto;
import com.example.w3_homework.model.Post;
import com.example.w3_homework.model.User;
import com.example.w3_homework.repository.PostRepository;
import com.example.w3_homework.security.UserDetailsImpl;
import com.example.w3_homework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @PostMapping
    public Post uploadPost(@RequestBody PostContentDto postContentDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        System.out.println("asdf");
        User user = userDetails.getUser();
        Post post = new Post(postContentDto, user);
        return postRepository.save(post);
    }

    @GetMapping("/{id}")
    public Post getOnePost(@PathVariable Long id){
        return postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("찾는 게시물이 없습니다."));
    }

    @PutMapping("/{id}")
    public Long modifyPost(@PathVariable Long id, @RequestBody PostContentDto postContentDto){
        return postService.update(id, postContentDto);
    }

    @DeleteMapping("/{id}")
    public Long delPost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;

    }
}