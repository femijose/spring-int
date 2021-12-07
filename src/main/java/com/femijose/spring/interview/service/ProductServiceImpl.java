package com.femijose.spring.interview.service;

import com.femijose.spring.interview.dao.ProductRepository;
import com.femijose.spring.interview.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<Product> findAll() {
       return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product findProduct(int productId) {
        Optional<Product> result = productRepository.findById(productId);
        Product product = null;
        if(result.isPresent()) {
            product = result.get();
        }
        return product;
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }
}
