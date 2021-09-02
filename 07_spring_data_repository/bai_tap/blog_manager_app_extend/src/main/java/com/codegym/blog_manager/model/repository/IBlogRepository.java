package com.codegym.blog_manager.model.repository;

import com.codegym.blog_manager.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findAllByHeaderContextContaining( String headerContext , Pageable pageable);

}
