package com.femijose.spring.interview.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;

    @Column(name="name")
    @NotEmpty(message = "Please provide the name of the product")
    private String name;

    @Column(name="description")
    @NotEmpty(message = "Please provide a description for the product")
    @Size(min = 8,max = 255, message = "Description should have at least 8 characters and Max 255 character")
    private  String description;


    @Column(name="cost")
    @NotNull(message = "Please provide a price")
    @DecimalMin("1.00")
    private double cost;

    @Column(name="quantity")
    @NotNull(message = "Please provide a quantity of the product")
    private int quantity;

    public Product() {
    }

    public Product(int id,String name, String description, double cost, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
}
