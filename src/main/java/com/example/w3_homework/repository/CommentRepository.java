package com.example.w3_homework.repository;

import com.example.w3_homework.model.Comment;
import com.example.w3_homework.model.Post;
import com.example.w3_homework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findAllByUser(User user);
    Optional<Comment> findAllByPost(Post post);
}
