package com.example.ecommerce.controller;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repo.CartItemRepository;
import com.example.ecommerce.repo.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartItemRepository cartRepo;
    private final ProductRepository productRepo;
    public CartController(CartItemRepository cartRepo, ProductRepository productRepo) {
        this.cartRepo = cartRepo; this.productRepo = productRepo;
    }

    @GetMapping public List<CartItem> view() { return cartRepo.findAll(); }

    @PostMapping("/add/{productId}")
    public ResponseEntity<CartItem> add(@PathVariable Long productId,
                                        @RequestParam(defaultValue = "1") int qty) {
        Product p = productRepo.findById(productId).orElse(null);
        if (p == null) return ResponseEntity.notFound().build();
        CartItem item = cartRepo.findAll().stream()
                .filter(c -> c.getProduct().getId().equals(productId)).findFirst()
                .orElse(new CartItem(p, 0));
        item.setQuantity(item.getQuantity() + qty);
        return ResponseEntity.ok(cartRepo.save(item));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> remove(@PathVariable Long itemId) {
        cartRepo.deleteById(itemId);
        return ResponseEntity.noContent().build();
    }
}
