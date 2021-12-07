package com.femijose.spring.interview.service;

import com.femijose.spring.interview.Exception.ProductNotFoundException;
import com.femijose.spring.interview.dao.OrderRepository;
import com.femijose.spring.interview.dao.ProductRepository;
import com.femijose.spring.interview.entity.Order;
import com.femijose.spring.interview.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

   // private static final String TOPIC = "orders";

   /* @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate; */

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public List<Order> allOrder() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Order addOrder(Order order) {
        Product product = isProductAvailability(order);
        if(product == null)throw new ProductNotFoundException("Product Not Available") ;
        String randomString = "INTR-"+Math.round(Math.random())+""+new Date().getTime();
        order.setId(0);
        order.setOrderNo(randomString);
        order.setTotalCost(order.getOrderQuantity() * product.getCost() );
        order.setOrderDate(new Date().toString());
        System.out.println("here");
       // this.kafkaTemplate.send(TOPIC,order);
        return orderRepository.save(order);
    }

    private Product  isProductAvailability(Order order) {
        Optional<Product> result = productRepository.findById(order.getProductID());
        Product product = null;
        if(result.isPresent()) {
            product = result.get();
            if (product.getQuantity() >= order.getOrderQuantity()) {
                int newQuantity = product.getQuantity() - order.getOrderQuantity();
               product.setQuantity(newQuantity);
               productRepository.save(product);
                return product;
            }
        }
        return product;
    }


}
