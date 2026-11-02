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

    public Order(int userId) {
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
