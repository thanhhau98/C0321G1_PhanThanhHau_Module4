package com.codegym.blog_manager.model.repository;

import com.codegym.blog_manager.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
}
