package com.example.springwithmongodb.controller;

import com.example.springwithmongodb.model.product.Product;
import com.example.springwithmongodb.service.product.ProductService;
import com.example.springwithmongodb.service.product.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final SearchService searchService;


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

    @GetMapping("/search/is")
    public ResponseEntity<List<Product>> searchByName(
        @RequestParam("name") String name
    ) {
        return ResponseEntity.ok(searchService.searchByName(name));
    }

    @GetMapping("/search/start-with")
    public ResponseEntity<List<Product>> searchByNameStartsWith(
            @RequestParam("name") String name
    ) {
        return ResponseEntity.ok(searchService.searchByNameStartingWith(name));
    }

    @GetMapping("/search/end-with")
    public ResponseEntity<List<Product>> searchByNameEndsWith(
            @RequestParam("name") String name
    ) {
        return ResponseEntity.ok(searchService.searchByNameEndingWith(name));
    }

    @GetMapping("/search/lt")
    public ResponseEntity<List<Product>> searchByPriceLt(
            @RequestParam("price") BigDecimal price
    ) {
        return ResponseEntity.ok(searchService.searchByPriceLt(price));
    }

    @GetMapping("/search/gt")
    public ResponseEntity<List<Product>> searchByPriceGt(
            @RequestParam("price") BigDecimal price
    ) {
        return ResponseEntity.ok(searchService.searchByPriceGt(price));
    }

    @GetMapping("/sort/asc")
    public ResponseEntity<List<Product>> sortAscByFieldName(
            @RequestParam("field") String field
    ) {
        return ResponseEntity.ok(searchService.sortAscByField(field));
    }

    @GetMapping("/sort-page")
    public ResponseEntity<List<Product>> sortAndPageByFieldName(
            @RequestParam("field") String field
    ) {
        return ResponseEntity.ok(searchService.sortAndPageByField(field));
    }

}
