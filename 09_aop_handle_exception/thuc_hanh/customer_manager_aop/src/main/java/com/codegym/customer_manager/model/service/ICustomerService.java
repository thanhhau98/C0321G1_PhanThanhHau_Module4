package com.codegym.customer_manager.model.service;

import java.util.List;

public interface ICustomerService<Customer> {
    List<Customer> findAll();

   Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

}
