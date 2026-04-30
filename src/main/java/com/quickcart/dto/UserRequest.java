package com.quickcart.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserRequest {
    @Email
    private String email;
    private String password;
    private String name;
}
