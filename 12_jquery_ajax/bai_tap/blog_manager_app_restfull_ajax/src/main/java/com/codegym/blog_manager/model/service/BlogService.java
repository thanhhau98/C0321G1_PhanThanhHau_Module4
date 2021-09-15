package com.codegym.blog_manager.model.service;

import com.codegym.blog_manager.model.bean.Blog;
import com.codegym.blog_manager.model.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAllByHeaderContextContaining(String headerContext, Pageable pageable) {
        return blogRepository.findAllByHeaderContextContaining(headerContext,pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {

        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByHeaderContextContaining(String headerContext) {
        return blogRepository.findByHeaderContextContaining(headerContext);
    }

    @Override
    public List<Blog> findByCategorys_Id(int id) {
        return blogRepository.findByCategorys_Id(id);
    }
}
