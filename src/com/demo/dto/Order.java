package com.demo.dto;

import com.demo.orderStatus.CreatedOrderState;
import com.demo.orderStatus.State;

import java.util.Date;
import java.util.List;

public class Order {
    String id;
    int userId;
    Date createdAt;
    State status;
    int productId;
    int quantity;
    int price;

    public Order(int userId, int productId, int quantity, int price) {
        this.userId = userId;

        createdAt = new Date();
        status = new CreatedOrderState();
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

    public State getStatus() {
        return status;
    }

    public void setStatus(State status) {
        this.status = status;
    }
}
