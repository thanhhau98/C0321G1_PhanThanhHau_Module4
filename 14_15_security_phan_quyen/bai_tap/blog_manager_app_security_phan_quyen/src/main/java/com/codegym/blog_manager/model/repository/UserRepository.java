package com.codegym.blog_manager.model.repository;

import com.codegym.blog_manager.model.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
