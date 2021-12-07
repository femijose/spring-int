package com.femijose.spring.interview.dao;

import com.femijose.spring.interview.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
