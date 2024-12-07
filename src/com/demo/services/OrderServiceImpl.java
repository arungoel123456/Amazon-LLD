package com.demo.services;

import com.demo.dto.Cart;
import com.demo.dto.CartProduct;
import com.demo.dto.Order;
import com.demo.dto.OrderProduct;
import com.demo.interfaces.CartService;
import com.demo.interfaces.OrderService;
import com.demo.interfaces.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    Map<String, Order> orders;
    CartService cartService;
    UserService userService;

    public OrderServiceImpl(CartService cartService, UserService userService) {
        this.cartService = cartService;
        orders= new HashMap<>();
        this.userService = userService;
    }

    @Override
    public void createOrder(int cartId) {
        List<CartProduct> cartProducts = cartService.fetchCartProducts(cartId);
        Cart cart = cartService.getCart(cartId);
        for(CartProduct cartProduct: cartProducts)
        {
            Order order = new Order(cart.getUserId(), cartProduct.getProduct().getId(), cartProduct.getQuantity(), cartProduct.getProduct().getPrice());
            orders.put(order.getId(), order);
            userService.getUser(cart.getUserId()).getOrders().add(order);
            cartService.removeFromCart(cartProduct.getId());
        }
    }
}
