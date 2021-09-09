package com.codegym.shopping_cart.model.repository;

import com.codegym.shopping_cart.model.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
