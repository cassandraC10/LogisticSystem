package com.cassandra.logisticSystem.data.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<Product> products;

    private Date orderDate;
    private String status;
    private double totalPrice;
    private String shippingAddress;

    // Constructors
    public Order() {
    }

    public Order(Long id, Customer customer, List<Product> products, String status, double totalPrice, String shippingAddress, Date orderDate) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.status = status;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
        this.orderDate = orderDate;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}

