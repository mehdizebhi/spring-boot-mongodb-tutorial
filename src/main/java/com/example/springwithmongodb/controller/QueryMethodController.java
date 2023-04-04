package com.example.springwithmongodb.controller;

import com.example.springwithmongodb.model.product.Product;
import com.example.springwithmongodb.service.product.QueryMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/method-query")
@RequiredArgsConstructor
public class QueryMethodController {

    private final QueryMethodService service;

    @GetMapping("/search/is")
    public ResponseEntity<List<Product>> searchByName(
            @RequestParam("name") String name
    ) {
        return ResponseEntity.ok(service.searchByName(name));
    }

    @GetMapping("/search/start-with")
    public ResponseEntity<List<Product>> searchByNameStartsWith(
            @RequestParam("name") String name
    ) {
        return ResponseEntity.ok(service.searchByNameStartingWith(name));
    }

    @GetMapping("/search/end-with")
    public ResponseEntity<List<Product>> searchByNameEndsWith(
            @RequestParam("name") String name
    ) {
        return ResponseEntity.ok(service.searchByNameEndingWith(name));
    }

    @GetMapping("/search/containing")
    public ResponseEntity<List<Product>> searchByNameContaining(
            @RequestParam("name") String name
    ) {
        return ResponseEntity.ok(service.searchByNameContaining(name));
    }

    @GetMapping("/search/lt")
    public ResponseEntity<List<Product>> searchByPriceLt(
            @RequestParam("price") BigDecimal price
    ) {
        return ResponseEntity.ok(service.searchByPriceLt(price));
    }

    @GetMapping("/search/gt")
    public ResponseEntity<List<Product>> searchByPriceGt(
            @RequestParam("price") BigDecimal price
    ) {
        return ResponseEntity.ok(service.searchByPriceGt(price));
    }

    @GetMapping("/search/between")
    public ResponseEntity<List<Product>> searchByPriceBetween(
            @RequestParam("price1") BigDecimal price1,
            @RequestParam("price2") BigDecimal price2
    ) {
        return ResponseEntity.ok(service.searchByPriceBetween(price1, price2));
    }

    @GetMapping("/sort/asc")
    public ResponseEntity<List<Product>> sortAscByFieldName(
            @RequestParam("field") String field
    ) {
        return ResponseEntity.ok(service.searchAndSortAsc(field));
    }

    @GetMapping("/sort-page")
    public ResponseEntity<List<Product>> sortAndPageByFieldName(
            @RequestParam("field") String field
    ) {
        return ResponseEntity.ok(service.sortAndPageByField(field));
    }

}
