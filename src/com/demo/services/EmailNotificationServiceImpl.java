package com.demo.services;

import com.demo.dto.User;
import com.demo.interfaces.NotificationService;

public class EmailNotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotification(String description, int userId) {
        System.out.println("sending email notification");
        // rest of the logic to send the email.
    }
}
