package com.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String id;
    private int userId;
    private List<CartProduct> cartProducts;

    public Cart(int userId) {
        this.userId = userId;
        this.cartProducts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
