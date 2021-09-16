package com.codegym.blog_manager.model.service;
import com.codegym.blog_manager.model.bean.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    //    void save(User user);
//    void update(User user);
    User findById(int id);
}
