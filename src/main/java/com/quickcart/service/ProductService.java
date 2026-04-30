package com.quickcart.service;

import com.quickcart.dto.ProductRequest;
import com.quickcart.entity.Product;
import com.quickcart.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product create(ProductRequest req) {
        Product p = new Product(null, req.getName(), req.getCategory(), req.getPrice(), false);
        return repository.save(p);
    }

    public List<Product> getAll() {
        return repository.findByDeletedFalse();
    }

    public Product update(Long id, ProductRequest req) {
        Product p = repository.findById(id).orElseThrow();
        p.setName(req.getName());
        p.setCategory(req.getCategory());
        p.setPrice(req.getPrice());
        return repository.save(p);
    }

    public void delete(Long id) {
        Product p = repository.findById(id).orElseThrow();
        p.setDeleted(true);
        repository.save(p);
    }
}