package com.demo.services;

import com.demo.dto.User;
import com.demo.interfaces.UserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    Map<Integer, User> users;

    public UserServiceImpl() {
        this.users = new HashMap<>();
    }

    @Override
    public boolean createUser(String email, String password) {
        User user = new User(email, password);
        users.put(user.getId(), user);
        return true;
    }

    @Override
    public User getUser(int id) {
        return users.get(id);
    }
}
