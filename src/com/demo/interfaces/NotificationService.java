package com.demo.interfaces;

import com.demo.dto.User;

public interface NotificationService {
    void sendNotification(String description, int userId);

}
