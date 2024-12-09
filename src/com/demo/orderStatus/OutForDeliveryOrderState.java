package com.demo.orderStatus;

import com.demo.dto.Order;
import com.demo.interfaces.NotificationService;
import com.demo.services.EmailNotificationServiceImpl;

public class OutForDeliveryOrderState extends State {

    public OutForDeliveryOrderState() {
        super(new EmailNotificationServiceImpl());
    }

    @Override
    public void sendNotification(Order order) {
        notificationService.sendNotification("order out form delivery", order.getUserId());
    }
}
