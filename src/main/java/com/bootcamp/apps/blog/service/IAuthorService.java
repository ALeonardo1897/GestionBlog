package com.bootcamp.apps.blog.service;

import com.bootcamp.apps.blog.entity.Author;

import java.util.Optional;

public interface IAuthorService {

    Author getById(Integer authorId);
    Author save(Author author);
    void delete(Integer authorId);
}
