package com.quickcart.service;

import com.quickcart.dto.UserRequest;
import com.quickcart.entity.User;
import com.quickcart.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(UserRequest request) {

        User user = new User();

        user.setEmail(request.getEmail());
        user.setName(request.getName());

        // encrypt password before saving
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        // default role
        user.setRole("USER");

        return userRepository.save(user);
    }
}