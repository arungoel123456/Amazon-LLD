package com.demo.services;

import com.demo.interfaces.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean initialPayment(int amount) {
        System.out.println("initiated the payment");
        return true;
    }
}
