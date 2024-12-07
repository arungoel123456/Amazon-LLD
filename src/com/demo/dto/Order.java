package com.demo.dto;

import com.demo.enums.OrderStatus;

import java.util.Date;
import java.util.List;

public class Order {
    String id;
    int userId;
    Date createdAt;
    OrderStatus status;
    int productId;
    int quantity;
    int price;

    public Order(int userId, int productId, int quantity, int price) {
        this.userId = userId;

        createdAt = new Date();
        status = OrderStatus.CREATED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
