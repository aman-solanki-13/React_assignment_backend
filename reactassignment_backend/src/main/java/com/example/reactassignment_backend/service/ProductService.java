package com.example.reactassignment_backend.service;

import com.example.reactassignment_backend.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    void addProductToCartTable(Long productId, String userEmail);
}
