package com.bootcamp.apps.blog.repository;

import com.bootcamp.apps.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
