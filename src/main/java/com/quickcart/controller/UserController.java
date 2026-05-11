package com.quickcart.controller;

import com.quickcart.dto.UserRequest;
import com.quickcart.entity.User;
import com.quickcart.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @Valid @RequestBody UserRequest request
    ) {
        return ResponseEntity.ok(
                service.register(request)
        );
    }
}