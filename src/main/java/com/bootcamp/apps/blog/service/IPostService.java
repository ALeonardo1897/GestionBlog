package com.bootcamp.apps.blog.service;

import com.bootcamp.apps.blog.entity.Post;

public interface IPostService {

    Post findById(Integer postId);
    Post save(Post post);
}
