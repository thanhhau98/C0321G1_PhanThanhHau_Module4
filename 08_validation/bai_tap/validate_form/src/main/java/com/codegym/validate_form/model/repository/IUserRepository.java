package com.codegym.validate_form.model.repository;

import com.codegym.validate_form.model.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
