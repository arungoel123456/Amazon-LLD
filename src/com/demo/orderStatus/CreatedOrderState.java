package com.demo.orderStatus;

import com.demo.dto.Order;
import com.demo.interfaces.NotificationService;
import com.demo.services.SmsNotificationServiceImpl;

public class CreatedOrderState extends State{


    public CreatedOrderState() {
        super(new SmsNotificationServiceImpl());
    }

    @Override
    public void sendNotification(Order order) {
        notificationService.sendNotification("Order created", order.getUserId());
    }
}
