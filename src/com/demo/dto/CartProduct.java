package com.demo.dto;

public class CartProduct {
    private Product product;
    private int quantity;
    int cartId;
    int id;

    public CartProduct(Product product, int quantity, int cartId) {
        this.product = product;
        this.quantity = quantity;
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getId() {
        return id;
    }

}
