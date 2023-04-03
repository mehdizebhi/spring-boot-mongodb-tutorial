package com.example.springwithmongodb.model.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Category {

    private String name;
    private String description;

}