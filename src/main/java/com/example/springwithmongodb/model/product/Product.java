package com.example.springwithmongodb.model.product;

import com.example.springwithmongodb.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private List<String> tags;
    @DBRef
    private Category category;
    private BigDecimal price;
    private double quantity;
    private double rating;
}
