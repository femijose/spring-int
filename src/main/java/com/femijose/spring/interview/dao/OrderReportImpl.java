package com.femijose.spring.interview.dao;

import com.femijose.spring.interview.entity.Order;
import com.femijose.spring.interview.entity.OrderReport;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Repository
public class OrderReportImpl implements OrderReportDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public  List<Order> getReport(String startDate, String endDate) {
        System.out.println("DAO"+startDate);
        Session session = entityManager.unwrap(Session.class);
        String hql = "FROM Order WHERE orderDate BETWEEN '"+startDate+"' and '"+endDate+"'";
        Query query = session.createQuery(hql);
       // query.setParameter("startDate",startDate);
      //  query.setParameter("endDate",endDate);
        List<Order> results = query.getResultList();
        return results;
    }
}
