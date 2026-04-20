package com.example.bsad.service;

import com.example.bsad.model.Product;
import com.example.bsad.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    @Cacheable("products")
    public List<Product> list() {
        return repo.findAll();
    }

    public Product create(Product p) {
        return repo.save(p);
    }
}
