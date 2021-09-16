package com.codegym.blog_manager.model.repository;

import com.codegym.blog_manager.model.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
