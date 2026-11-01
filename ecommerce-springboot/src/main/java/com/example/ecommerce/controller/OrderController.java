package com.example.ecommerce.controller;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repo.CartItemRepository;
import com.example.ecommerce.repo.OrderRepository;
import com.example.ecommerce.repo.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderRepository orderRepo;
    private final CartItemRepository cartRepo;
    private final ProductRepository productRepo;
    public OrderController(OrderRepository o, CartItemRepository c, ProductRepository p) {
        this.orderRepo = o; this.cartRepo = c; this.productRepo = p;
    }

    @GetMapping public List<Order> all() { return orderRepo.findAll(); }

    @PostMapping("/checkout")
    @Transactional
    public ResponseEntity<?> checkout(@RequestBody Map<String, String> body) {
        List<CartItem> items = cartRepo.findAll();
        if (items.isEmpty()) return ResponseEntity.badRequest().body("Cart is empty");
        double total = 0;
        StringBuilder sb = new StringBuilder();
        for (CartItem ci : items) {
            Product p = ci.getProduct();
            if (p.getStock() < ci.getQuantity())
                return ResponseEntity.badRequest().body("Not enough stock for " + p.getName());
            p.setStock(p.getStock() - ci.getQuantity());
            productRepo.save(p);
            total += p.getPrice() * ci.getQuantity();
            sb.append(p.getName()).append(" x").append(ci.getQuantity()).append("; ");
        }
        Order order = new Order();
        order.setCustomerName(body.getOrDefault("name", "Guest"));
        order.setAddress(body.getOrDefault("address", ""));
        order.setItemsSummary(sb.toString());
        order.setTotal(total);
        orderRepo.save(order);
        cartRepo.deleteAll();
        return ResponseEntity.ok(order);
    }
}
