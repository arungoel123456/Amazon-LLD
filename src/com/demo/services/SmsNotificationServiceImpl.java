package com.demo.services;

import com.demo.dto.User;
import com.demo.interfaces.NotificationService;

public class SmsNotificationServiceImpl implements NotificationService {
    @Override
    public void sendNotification(String description, int userId) {
        System.out.println("Sending a sms notification");
    }
}
