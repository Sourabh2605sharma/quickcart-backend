package com.quickcart.controller;

import com.quickcart.dto.LoginRequest;
import com.quickcart.dto.UserRequest;
import com.quickcart.entity.User;
import com.quickcart.service.AuthService;
import com.quickcart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody UserRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}