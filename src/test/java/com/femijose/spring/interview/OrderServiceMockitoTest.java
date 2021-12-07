package com.femijose.spring.interview;


import com.femijose.spring.interview.dao.OrderRepository;
import com.femijose.spring.interview.dao.ProductRepository;
import com.femijose.spring.interview.entity.Order;
import com.femijose.spring.interview.entity.Product;
import com.femijose.spring.interview.service.OrderService;
import com.femijose.spring.interview.service.OrderServiceImpl;
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


@SpringBootTest(classes = {OrderServiceMockitoTest.class})
public class OrderServiceMockitoTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    OrderServiceImpl orderService;

    public List<Order> orders;

    @Test
    public void test_allOrder(){
        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order(1,"Femi Jose","08058051937","Lagos",1, new Date().toString(),1,"INT-1012"));
        orders.add(new Order(2,"Ayo Jose","08058051937","Lagos",1, new Date().toString(),1,"INT-1012"));

        when(orderRepository.findAll()).thenReturn(orders);
        assertEquals(2,orderService.allOrder().size());
    }

    @Test
    public void test_addOrder() {
        Order order = new Order(1,"Femi Jose","08058051937","Lagos",1, new Date().toString(),1,"INT-1012");
        Product product = new Product(1,"TV", "Best TV",1000.00,2);
        int productID = 1;
        when(productRepository.findById(productID)).thenReturn(Optional.of(product));
        when(orderRepository.save(order)).thenReturn(order);
        assertEquals(order,orderService.addOrder(order));

    }

}
