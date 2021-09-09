package com.codegym.shopping_cart_full.model.service;

import com.codegym.shopping_cart_full.model.bean.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(long id);

    void save (Product product);
}
