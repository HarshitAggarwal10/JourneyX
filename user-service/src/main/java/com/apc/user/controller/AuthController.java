package com.apc.user.controller;

import com.apc.user.dto.LoginRequest;
import com.apc.user.dto.RegisterRequest;
import com.apc.user.entity.User;
import com.apc.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return userService.register(user);
    }

    // ✅ LOGIN (RETURN TOKEN AS JSON)
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        String token = userService.login(
                request.getUsername(),
                request.getPassword()
        );

        return Map.of("token", token);
    }
}
