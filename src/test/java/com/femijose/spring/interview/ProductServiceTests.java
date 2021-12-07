package com.femijose.spring.interview;

import com.femijose.spring.interview.dao.ProductRepository;
import com.femijose.spring.interview.entity.Order;
import com.femijose.spring.interview.entity.Product;
import com.femijose.spring.interview.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ProductServiceTests.class})
public class ProductServiceTests {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    public List<Order> orders;

    @Test
    public void test_findAll(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1,"TV", "Best TV",1000.00,2));
        products.add(new Product(2,"Radio", "Best TV",1000.00,2));

        when(productRepository.findAll()).thenReturn(products);
        assertEquals(2,productService.findAll().size());
    }

    @Test
    public void test_addProduct() {
        Product product = new Product(1,"TV", "Best TV",1000.00,2);
        when(productRepository.save(product)).thenReturn(product);
        assertEquals(product,productService.addProduct(product));
    }

    @Test
    public void test_findProduct() {
        Product product = new Product(1,"TV", "Best TV",1000.00,2);
        int productID = 1;
        when(productRepository.findById(productID)).thenReturn(Optional.of(product));
        assertEquals(product,productService.findProduct(productID));
    }


}
