package com.apc.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apc.user.entity.User;
import com.apc.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public User getProfile(Authentication authentication) {
        String username = authentication.getName();
        return userService.getUserByUsername(username);
    }

    @GetMapping("/profile")
    public Map<String, Object> profile(Authentication auth) {
        Map<String, Object> data = new HashMap<>();
        data.put("username", auth.getName());
        data.put("role", auth.getAuthorities());
        return data;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "Admin access granted";
    }
}
