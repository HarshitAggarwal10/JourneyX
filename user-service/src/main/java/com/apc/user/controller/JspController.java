package com.apc.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {

    @GetMapping("/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register-page")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/profile-page")
    public String profilePage() {
        return "profile";
    }
}

