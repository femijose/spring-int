package com.femijose.spring.interview.rest;

import com.femijose.spring.interview.Exception.ProductNotFoundException;
import com.femijose.spring.interview.dao.OrderReportDAO;
import com.femijose.spring.interview.entity.Order;
import com.femijose.spring.interview.entity.OrderReport;
import com.femijose.spring.interview.entity.Product;
import com.femijose.spring.interview.service.OrderReportService;
import com.femijose.spring.interview.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private OrderReportService orderReportService;

    @GetMapping("/{start_date}/{end_date}")
    public OrderReport report (@PathVariable String start_date, @PathVariable String end_date) {
        List<Order> orders = orderReportService.OrderReport(start_date,end_date);
        double totalSum = orders.stream().mapToDouble(order-> order.getTotalCost()).sum();
        OrderReport orderReport = new OrderReport(start_date+" - "+end_date,orders.size(),totalSum);
        return orderReport;
    }
}
