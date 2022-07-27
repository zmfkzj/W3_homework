package com.example.w3_homework.controller;

import com.example.w3_homework.dto.PassDto;
import com.example.w3_homework.dto.PostDto;
import com.example.w3_homework.entity.Post;
import com.example.w3_homework.repository.PostRepository;
import com.example.w3_homework.service.PostService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    public Post uploadPost(@RequestBody PostDto postDto){
        Post post = new Post(postDto);
        return postRepository.save(post);
    }

    @GetMapping("/{id}")
    public Post getOnePost(@PathVariable Long id){
        return postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("찾는 게시물이 없습니다."));
    }

    @PostMapping("/{id}")
    public boolean checkPass(@PathVariable Long id, @RequestBody PassDto passDto){
        return postService.checkPass(id, passDto.getPassword());
    }

    @PutMapping("/{id}")
    public Long modifyPost(@PathVariable Long id, @RequestBody PostDto postDto){
        return postService.update(id, postDto);
    }

    @DeleteMapping("/{id}")
    public Long delPost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;

    }
}