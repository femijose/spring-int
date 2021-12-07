package com.femijose.spring.interview.service;

import com.femijose.spring.interview.dao.OrderRepository;
import com.femijose.spring.interview.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    public List<Order> allOrder();
    public Order addOrder(Order order);

}
