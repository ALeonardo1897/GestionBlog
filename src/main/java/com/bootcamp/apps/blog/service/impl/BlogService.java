package com.bootcamp.apps.blog.service.impl;

import com.bootcamp.apps.blog.entity.Author;
import com.bootcamp.apps.blog.entity.Blog;
import com.bootcamp.apps.blog.exception.ConflictException;
import com.bootcamp.apps.blog.exception.NotFoundException;
import com.bootcamp.apps.blog.repository.AuthorRepository;
import com.bootcamp.apps.blog.repository.BlogRepository;
import com.bootcamp.apps.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    private BlogRepository blogRepository;
    private AuthorService authorService;

    @Autowired
    public BlogService (
            BlogRepository blogRepository,
            AuthorService authorService){
        this.blogRepository = blogRepository;
        this.authorService = authorService;
    }

    @Override
    public Blog findById(Integer blogId) {
        return blogRepository.findById(blogId).orElseThrow(() -> new NotFoundException("blog.notFound"));
    }

    @Override
    public Blog saveBlog(Blog request) {

        Author author = authorService.getById(request.getAuthor().getId());

        if(!authorService.isOlderThan18(author)) throw new ConflictException("author.isNotOlderThan18");
        if(hasMore3Blogs(author)) throw new ConflictException("blog.max3");

        return blogRepository.save(request);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    private boolean hasMore3Blogs(Author author){
        return blogRepository.countByAuthor(author) >= 3 ? true : false;
    }

}
