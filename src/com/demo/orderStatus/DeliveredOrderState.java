package com.demo.orderStatus;

import com.demo.dto.Order;
import com.demo.interfaces.NotificationService;
import com.demo.services.SmsNotificationServiceImpl;

public class DeliveredOrderState extends State{

    public DeliveredOrderState() {
        super(new SmsNotificationServiceImpl());
    }

    @Override
    public void sendNotification(Order order) {
        notificationService.sendNotification("Order delivered successfully", order.getUserId());
    }
}
