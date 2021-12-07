package com.femijose.spring.interview.entity;

import javax.persistence.*;
import javax.validation.MessageInterpolator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="Orders")
public class Order {

    @ManyToOne()
    @JoinColumn(name = "product_id",insertable = false,updatable = false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="customer_name")
    @NotEmpty(message = "Please Enter The Customer's Name")
    private String customerName;

    @Column(name="customer_phone")
    @NotEmpty(message = "Please Enter The Customer's Phone Number")
    @Size(min = 11,max = 11, message = "Phone must be 11 digits")
    private String customerPhone;

    @Column(name="customer_address")
    @NotEmpty(message = "Please Enter The Customer's Address ")
    @Size(max = 255, message = "Address Should Not Be More Than 255 Characters")
    private String customerAddress;

    @Column(name="order_quantity")
    @NotNull
    @Min(value = 1, message = "Quantity Must At Least Be 1")
    private int orderQuantity;

    @Column(name="order_date")
    private String orderDate;

    @Column(name="product_id")
    @NotNull
    @Min(value = 1, message = "Please Enter Product ID")
    private int productID;

    @Column(name="order_no")
    private String orderNo;

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Column(name="total_cost")
    private double totalCost;

    public Order () {

    }
    public Order(int id, String customerName, String customerPhone, String customerAddress, int orderQuantity, String orderDate, int productID, String orderNo) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.orderQuantity = orderQuantity;
        this.orderDate = orderDate;
        this.productID = productID;
        this.orderNo = orderNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
