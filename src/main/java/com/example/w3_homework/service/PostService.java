package com.example.w3_homework.service;

import com.example.w3_homework.dto.PostContentDto;
import com.example.w3_homework.model.Post;
import com.example.w3_homework.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Transactional
    public Long update(Long id, PostContentDto postContentDto){
        Post post1 = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));
        post1.update(postContentDto);
        return post1.getId();
    }
}
