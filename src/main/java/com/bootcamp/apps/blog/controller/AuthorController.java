package com.bootcamp.apps.blog.controller;

import com.bootcamp.apps.blog.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController( AuthorService authorService){
        this.authorService = authorService;
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Integer authorId){
        this.authorService.delete(authorId);
    }
}
