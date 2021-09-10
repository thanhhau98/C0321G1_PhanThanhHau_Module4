package com.codegym.restfull.model.repository;

import com.codegym.restfull.model.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository  extends JpaRepository<Customer,Long> {
}
