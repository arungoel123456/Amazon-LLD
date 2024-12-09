package com.demo.orderStatus;

import com.demo.dto.Order;
import com.demo.interfaces.NotificationService;

public abstract class State {
    NotificationService notificationService;

    public State(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public abstract void sendNotification(Order order);
}
