package com.apc.user.controller;

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

    // ✅ USER PROFILE (JWT protected)
    @GetMapping("/profile")
    public User getProfile(Authentication authentication) {
        String username = authentication.getName();
        return userService.getUserByUsername(username);
    }

    // ✅ ADMIN ONLY ENDPOINT
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "Admin access granted";
    }
}
