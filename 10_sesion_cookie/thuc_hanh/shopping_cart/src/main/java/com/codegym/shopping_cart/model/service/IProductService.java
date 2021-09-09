package com.codegym.shopping_cart.model.service;

import com.codegym.shopping_cart.model.bean.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
