package com.demo.services;

import com.demo.dto.Cart;
import com.demo.dto.CartProduct;
import com.demo.dto.Order;
import com.demo.dto.OrderProduct;
import com.demo.interfaces.*;
import com.demo.orderStatus.DeliveredOrderState;
import com.demo.orderStatus.OutForDeliveryOrderState;
import com.demo.orderStatus.State;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReentrantLock;

public class OrderServiceImpl implements OrderService {

    Map<String, Order> orders;
    CartService cartService;
    UserService userService;
    PaymentService paymentService;
    ProductService productService;
    ReentrantLock lock;

    public OrderServiceImpl(CartService cartService, UserService userService, PaymentService paymentService, ProductService productService) {
        this.cartService = cartService;
        orders= new HashMap<>();
        this.userService = userService;
        this.paymentService = paymentService;
        this.productService = productService;
        lock = new ReentrantLock();
    }

    @Override
    public void createOrder(int cartId) {
        int cost;
        Cart cart = cartService.getCart(cartId);
        List<CartProduct> cartProducts = cartService.fetchCartProducts(cartId);
        cost = cartProducts.stream().mapToInt(cartProduct -> cartProduct.getProduct().getPrice()).sum();

        CompletableFuture<Boolean> paymentFuture = CompletableFuture.supplyAsync(() -> {
            return paymentService.initialPayment(cost);
        });

        paymentFuture.thenAccept(paymentSuccess -> {
            if (paymentSuccess) {
                // Proceed to create orders if payment was successful
                for (CartProduct cartProduct : cartProducts) {
//                    if(lock.tryLock())
//                    {
//                        lock.lock();
//                        productService.checkQuantity(cartProduct.getProduct().getId(), cartProduct.getQuantity());
//                        Order order = new Order(cart.getUserId(), cartProduct.getProduct().getId(), cartProduct.getQuantity(), cartProduct.getProduct().getPrice());
//                        orders.put(order.getId(), order);
//                        userService.getUser(cart.getUserId()).getOrders().add(order);
//                        cartService.removeFromCart(cartProduct.getId());
//                        lock.unlock();
//                    }
                    synchronized (cartProduct.getProduct()){
                        productService.checkQuantity(cartProduct.getProduct().getId(), cartProduct.getQuantity());
                        Order order = new Order(cart.getUserId(), cartProduct.getProduct().getId(), cartProduct.getQuantity(), cartProduct.getProduct().getPrice());
                        orders.put(order.getId(), order);
                        userService.getUser(cart.getUserId()).getOrders().add(order);
                        cartService.removeFromCart(cartProduct.getId());
                    }
                }
                System.out.println("Order creation successful");
            } else {
                // Handle payment failure
                System.err.println("Payment failed. Order creation aborted.");
            }
        }).exceptionally(ex -> {
            // Handle any exceptions during the process
            System.err.println("An error occurred: ");
            return null;
        });
    }

    @Override
    public void sendOrderForDelivery(String orderId) {
        Order order = orders.get(orderId);
        State outForDeliveryOrderState = new OutForDeliveryOrderState();
        changeState(outForDeliveryOrderState, order);
    }

    @Override
    public void delivered(String orderId) {
        Order order = orders.get(orderId);
        State deliveredOrderState = new DeliveredOrderState();
        changeState(deliveredOrderState, order);
    }

    private void changeState(State state, Order order) {
        order.setStatus(state);
        state.sendNotification(order);
    }
}
