package com.codegym.blog_manager.model.service;

import com.codegym.blog_manager.model.bean.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);
}
