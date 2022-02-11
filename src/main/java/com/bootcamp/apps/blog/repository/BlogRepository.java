package com.bootcamp.apps.blog.repository;

import com.bootcamp.apps.blog.entity.Author;
import com.bootcamp.apps.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    @Override
    Optional<Blog> findById(Integer integer);
    int countByAuthor(Author author);
}
