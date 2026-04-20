package com.example.bsad.controller;

import com.example.bsad.model.Product;
import com.example.bsad.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService service;

    @GetMapping
    public List<Product> list() {
        return service.list();
    }

    @PostMapping
    public Product create(@RequestBody Product p) {
        return service.create(p);
    }
}
