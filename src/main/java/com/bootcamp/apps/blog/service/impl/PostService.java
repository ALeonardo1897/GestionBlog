package com.bootcamp.apps.blog.service.impl;

import com.bootcamp.apps.blog.entity.Blog;
import com.bootcamp.apps.blog.entity.BlogStatus;
import com.bootcamp.apps.blog.entity.Post;
import com.bootcamp.apps.blog.exception.ConflictException;
import com.bootcamp.apps.blog.exception.NotFoundException;
import com.bootcamp.apps.blog.repository.PostRepository;
import com.bootcamp.apps.blog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PostService implements IPostService {

    private PostRepository postRepository;
    private BlogService blogService;

    @Autowired
    public PostService(PostRepository postRepository, BlogService blogService){
        this.postRepository = postRepository;
        this.blogService = blogService;
    }

    @Override
    public Post findById(Integer postId) {
        return postRepository.findById(postId).orElseThrow(() -> new NotFoundException("post.notFound"));
    }

    @Override
    public Post save(Post post) {

        Blog blog = blogService.findById(post.getBlog().getId());

        if(!blog.getStatus().equals(BlogStatus.ACTIVE)) throw new ConflictException("blog.isNotActive");
        if(existAnotherPostToday(blog)) throw new ConflictException("post.existAnotherPostToday");

        return postRepository.save(post);
    }

    private boolean existAnotherPostToday(Blog blog){

        Optional<Post> optionalPost = postRepository.findFirstByBlogOrderByDateDesc(blog);

        if(optionalPost.isEmpty()) return false;

        long diffInMillies = Math.abs(new Date().getTime() - optionalPost.get().getDate().getTime());
        long diff = (diffInMillies / (1000 * 60 * 60 * 24)) % 365;

        return diff > 1 ? false : true;
    }
}
