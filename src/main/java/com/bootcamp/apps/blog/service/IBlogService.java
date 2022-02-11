package com.bootcamp.apps.blog.service;

import com.bootcamp.apps.blog.entity.Blog;

import java.util.List;

public interface IBlogService {

    Blog findById(Integer blogId);
    Blog saveBlog(Blog request);
    List<Blog> findAll();

}
