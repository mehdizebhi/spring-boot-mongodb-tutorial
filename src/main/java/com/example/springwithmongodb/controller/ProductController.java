package com.example.springwithmongodb.controller;

import com.example.springwithmongodb.model.product.Product;
import com.example.springwithmongodb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;


    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<String> register(
            @RequestBody Product product
    ) {
        return ResponseEntity.ok(service.save(product));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remove(
            @PathVariable String id
    ) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
