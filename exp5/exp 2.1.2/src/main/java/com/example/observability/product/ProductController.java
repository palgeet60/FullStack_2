package com.example.observability.product;

import com.example.observability.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Map<Long, Product> PRODUCTS = Map.of(
            1L, new Product(1L, "Spring Boot Observability Kit", 1499.0),
            2L, new Product(2L, "Structured Logging Guide", 799.0));

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Product product = PRODUCTS.get(id);
        if (product == null) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        return ResponseEntity.ok(product);
    }

    public record Product(long id, String name, double price) {
    }
}
