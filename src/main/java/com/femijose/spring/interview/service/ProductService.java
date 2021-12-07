package com.femijose.spring.interview.service;

import com.femijose.spring.interview.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findProduct(int productId);
    public Product addProduct(Product product);
}
