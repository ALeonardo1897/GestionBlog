package com.bootcamp.apps.blog.service.impl;

import com.bootcamp.apps.blog.entity.Comment;
import com.bootcamp.apps.blog.entity.Post;
import com.bootcamp.apps.blog.entity.PostStatus;
import com.bootcamp.apps.blog.exception.ConflictException;
import com.bootcamp.apps.blog.repository.CommentRepository;
import com.bootcamp.apps.blog.service.ICommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {

    private CommentRepository commentRepository;
    private PostService postService;

    public CommentService(
            CommentRepository commentRepository,
            PostService postService){
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    @Override
    public Comment save(Comment comment) {

        Post post = postService.findById(comment.getPost().getId());

        if(!post.getStatus().equals(PostStatus.PUBLISHED)) throw new ConflictException("post.isNotPublished");

        return commentRepository.save(comment);
    }
}
