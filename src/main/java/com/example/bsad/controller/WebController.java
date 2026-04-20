package com.example.bsad.controller;

import com.example.bsad.model.Product;
import com.example.bsad.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final ProductService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "BSAD Open Framework 2.0 (Spring Boot 3)");
        model.addAttribute("products", service.list());
        return "index";
    }

    @PostMapping("/products")
    public String create(@ModelAttribute Product p) {
        service.create(p);
        return "redirect:/";
    }
}
