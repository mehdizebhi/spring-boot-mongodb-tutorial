package com.example.springwithmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWithMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWithMongodbApplication.class, args);
    }

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
