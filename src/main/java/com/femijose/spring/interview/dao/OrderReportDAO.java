package com.femijose.spring.interview.dao;

import com.femijose.spring.interview.entity.Order;
import com.femijose.spring.interview.entity.OrderReport;

import java.util.List;

public interface OrderReportDAO {

    public List<Order> getReport(String startDate, String endDate);
}
