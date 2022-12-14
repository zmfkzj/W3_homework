package com.example.w3_homework.repository;

import com.example.w3_homework.model.Post;
import com.example.w3_homework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findAllByUser(User user);
}
