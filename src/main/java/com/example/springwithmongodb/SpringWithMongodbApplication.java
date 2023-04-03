package com.example.springwithmongodb;

import com.example.springwithmongodb.model.category.Category;
import com.example.springwithmongodb.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringWithMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWithMongodbApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(
//            CategoryRepository categoryRepository
//    ) {
//        return args -> {
//            var category1 = Category.builder()
//                    .name("cat 1")
//                    .description("desc 1")
//                    .build();
//            var category2 = Category.builder()
//                    .name("cat 2")
//                    .description("desc 2")
//                    .build();
//            categoryRepository.insert(category1);
//            categoryRepository.insert(category2);
//        };
//    }

    /*@Bean
    public CommandLineRunner commandLineRunner(
            ProductRepository repository
    ) {
        return args -> {
            Product product = Product.builder()
                    .name("iPhone")
                    .description("Smart Phone")
                    .build();
            repository.insert(product);
        };
    }*/


}
