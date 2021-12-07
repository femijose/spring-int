package com.femijose.spring.interview.service;

import com.femijose.spring.interview.entity.Order;
import com.femijose.spring.interview.entity.OrderReport;

import java.util.Date;
import java.util.List;


public interface OrderReportService {

    public List<Order> OrderReport(String startDate, String endDate);

}
