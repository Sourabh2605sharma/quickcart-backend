package com.quickcart.service;

import com.quickcart.dto.UserRequest;
import com.quickcart.entity.User;
import com.quickcart.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(UserRequest request) {
        User user = new User(null, request.getEmail(), request.getPassword(), request.getName());
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
