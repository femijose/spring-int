package com.femijose.spring.interview.service;

import com.femijose.spring.interview.dao.OrderReportDAO;
import com.femijose.spring.interview.dao.OrderRepository;
import com.femijose.spring.interview.entity.Order;
import com.femijose.spring.interview.entity.OrderReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class OrderReportServiceImpl implements OrderReportService {

    @Autowired
    private OrderReportDAO orderReportDAO;


    @Override
    public List<Order> OrderReport(String startDate, String endDate) {
        return orderReportDAO.getReport(startDate,endDate);
    }


   /* @KafkaListener(topics = "orders", groupId = "group_id")
    public void consume(Order order) throws IOException {
        System.out.println(order);
    } */
}
