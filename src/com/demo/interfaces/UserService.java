package com.demo.interfaces;

import com.demo.dto.User;

public interface UserService {
    boolean createUser(String email, String password);
    User getUser(int id);
}
