package com.codegym.blog_manager.model.repository;

import com.codegym.blog_manager.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    List<Blog> findByCategorys_Id(int id);

    Page<Blog> findAllByHeaderContextContaining( String headerContext , Pageable pageable);

}
