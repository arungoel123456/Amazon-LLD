package com.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String password;
    private String email;
    private Cart cart;
    private List<Order> orders;

    public User(String password, String email) {
        this.password = password;
        this.email = email;
        this.cart = new Cart(this.id);
        orders = new ArrayList<>();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
