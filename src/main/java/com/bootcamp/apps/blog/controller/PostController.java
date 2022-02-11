package com.bootcamp.apps.blog.controller;

import com.bootcamp.apps.blog.entity.Post;
import com.bootcamp.apps.blog.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public Post savePost(@RequestBody Post request){
        return postService.save(request);
    }
}
