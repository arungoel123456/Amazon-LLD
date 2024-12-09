package com.demo.interfaces;

public interface OrderService {
    void createOrder(int cartId);
    void sendOrderForDelivery(String orderId);
    void delivered(String orderId);
}
