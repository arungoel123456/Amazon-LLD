package com.demo.interfaces;

import com.demo.dto.Cart;
import com.demo.dto.CartProduct;

import java.util.List;

public interface CartService {

    boolean addToCart(int cartId, int productId, int quantity);
    boolean removeFromCart(int cartProductId);
    List<CartProduct> fetchCartProducts(int cartId);
    Cart getCart(int cartId);
}
