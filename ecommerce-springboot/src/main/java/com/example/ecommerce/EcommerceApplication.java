package com.example.ecommerce;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    // Sample products
    @Bean
    CommandLineRunner seed(ProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Product("Laptop", "14 inch, 16GB RAM", 55000, "https://picsum.photos/seed/laptop/300/200", 10));
                repo.save(new Product("Smartphone", "128GB, 5G", 18000, "https://picsum.photos/seed/phone/300/200", 25));
                repo.save(new Product("Headphones", "Wireless, noise cancelling", 2500, "https://picsum.photos/seed/headphones/300/200", 40));
                repo.save(new Product("Backpack", "Water resistant, 30L", 1200, "https://picsum.photos/seed/bag/300/200", 30));
                repo.save(new Product("Smart Watch", "Heart rate, GPS", 3500, "https://picsum.photos/seed/watch/300/200", 15));
            }
        };
    }
}
