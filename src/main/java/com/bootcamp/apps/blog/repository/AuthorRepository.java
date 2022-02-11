package com.bootcamp.apps.blog.repository;

import com.bootcamp.apps.blog.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Override
    Optional<Author> findById(Integer integer);


}
