package com.codegym.customer_manager.model.repository;

import com.codegym.customer_manager.model.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {

}
