package com.femijose.spring.interview.entity;

public class OrderReport {
    private String dateRange;
    private int totalOrder;
    private double totalAmount;

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public OrderReport(String dateRange, int totalOrder, double totalAmount) {
        this.dateRange = dateRange;
        this.totalOrder = totalOrder;
        this.totalAmount = totalAmount;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
