package com.femijose.spring.interview.rest;

import com.femijose.spring.interview.entity.Order;
import com.femijose.spring.interview.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> allOrder() {
      return orderService.allOrder();
    }

    @PostMapping("/add")
    public Order addOrder(@Valid @RequestBody Order order) {
        return orderService.addOrder(order);
    }



}
