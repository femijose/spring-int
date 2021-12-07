package com.femijose.spring.interview.dao;

import com.femijose.spring.interview.entity.Order;
import com.femijose.spring.interview.entity.OrderReport;
import com.femijose.spring.interview.service.OrderReportService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface OrderRepository extends JpaRepository<Order, Integer> {


    @Query(value= "SELECT new OrderReport (order_date as dateRange, COUNT(*) as totalOrder,sum(total_cost) as totalAmount) FROM Orders WHERE order_date BETWEEN :startDate and :endDate", nativeQuery = true)
    OrderReport OrderReport(String startDate, String endDate);
}
