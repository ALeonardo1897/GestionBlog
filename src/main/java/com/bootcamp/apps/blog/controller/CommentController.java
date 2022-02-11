package com.bootcamp.apps.blog.controller;

import com.bootcamp.apps.blog.entity.Comment;
import com.bootcamp.apps.blog.service.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping
    public Comment save(@RequestBody Comment request){
        return this.commentService.save(request);
    }
}
