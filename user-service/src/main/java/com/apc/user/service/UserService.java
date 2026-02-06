package com.apc.user.service;

import com.apc.user.entity.User;

public interface UserService {
    User register(User user);
    String login(String username, String password);
    User getUserByUsername(String username);
}
