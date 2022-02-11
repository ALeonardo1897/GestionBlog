package com.bootcamp.apps.blog.repository;

import com.bootcamp.apps.blog.entity.Blog;
import com.bootcamp.apps.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Integer> {

    Optional<Post> findById(Integer id);
    Optional<Post> findFirstByBlogOrderByDateDesc(Blog blog);
}
