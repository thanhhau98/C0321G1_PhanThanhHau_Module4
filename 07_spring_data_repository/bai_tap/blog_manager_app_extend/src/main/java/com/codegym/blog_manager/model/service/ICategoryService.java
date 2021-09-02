package com.codegym.blog_manager.model.service;

import com.codegym.blog_manager.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);

    Category findById(int id);

    void save(Category blog);

    void remove(int id);
}
