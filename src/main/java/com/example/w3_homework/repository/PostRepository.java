package com.example.w3_homework.repository;

import com.example.w3_homework.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
