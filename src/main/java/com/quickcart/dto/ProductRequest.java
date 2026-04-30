package com.quickcart.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String category;
    private double price;
}