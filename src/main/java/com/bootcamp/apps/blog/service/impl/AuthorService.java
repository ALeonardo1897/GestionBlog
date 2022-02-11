package com.bootcamp.apps.blog.service.impl;

import com.bootcamp.apps.blog.entity.Author;
import com.bootcamp.apps.blog.exception.NotFoundException;
import com.bootcamp.apps.blog.repository.AuthorRepository;
import com.bootcamp.apps.blog.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class AuthorService implements IAuthorService {

    private AuthorRepository authorRepository;
    private BlogService blogService;

    @Autowired
    public AuthorService (AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getById(Integer authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow( () -> new NotFoundException("authorId.NotFound"));
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Integer authorId) {

        Author author = this.getById(authorId);

        this.authorRepository.delete(author);
    }

    public boolean isOlderThan18(Author author){

        long diffInMillies = Math.abs(new Date().getTime() - author.getBirthDate().getTime());
        long diff = (diffInMillies / (1000l * 60 * 60 * 24 * 365));

        return diff > 18 ? true : false;
    }
}
