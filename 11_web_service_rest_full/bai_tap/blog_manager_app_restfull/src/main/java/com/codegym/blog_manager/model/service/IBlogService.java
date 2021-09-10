package com.codegym.blog_manager.model.service;

import com.codegym.blog_manager.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IBlogService {

    Page<Blog> findAllByHeaderContextContaining( String headerContext , Pageable pageable);

    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    List<Blog> findByCategorys_Id(int id);
}
