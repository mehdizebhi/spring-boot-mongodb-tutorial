package com.example.springwithmongodb.service.product;

import com.example.springwithmongodb.model.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final MongoTemplate template;

    public List<Product> searchByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return template.find(query, Product.class);
    }

    public List<Product> searchByNameStartingWith(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("^" + name));
        return template.find(query, Product.class);
    }

    public List<Product> searchByNameEndingWith(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name + "$"));
        return template.find(query, Product.class);
    }

    public List<Product> searchByPriceLt(BigDecimal price) {
        Query query = new Query();
        query.addCriteria(Criteria.where("price").lt(price));
        return template.find(query, Product.class);
    }

    public List<Product> searchByPriceGt(BigDecimal price) {
        Query query = new Query();
        query.addCriteria(Criteria.where("price").gt(price));
        return template.find(query, Product.class);
    }

    public List<Product> sortAscByField(String fieldName) {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC, fieldName));
        return template.find(query, Product.class);
    }

    public List<Product> sortAndPageByField(String fieldName) {
        Query query = new Query();
        Pageable pageable = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, fieldName));
        query.with(pageable);
        return template.find(query, Product.class);
    }
}
