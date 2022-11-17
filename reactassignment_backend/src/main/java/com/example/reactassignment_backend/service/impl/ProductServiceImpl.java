package com.example.reactassignment_backend.service.impl;

import com.example.reactassignment_backend.entities.Product;
import com.example.reactassignment_backend.exception.ProductNotFoundException;
import com.example.reactassignment_backend.repository.ProductRepository;
import com.example.reactassignment_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Override
    public List<Product> getAllProducts() {
        List<Product> allAvailableProducts = productRepository.findAll();
        return allAvailableProducts.stream().filter(product -> product.getProductQuantity() > 0).toList();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product", "Id", id));
    }

    @Override
    public void addProductToCartTable(Long productId, String userEmail) {
        productRepository.addProductToCartTable(productId, userEmail);
    }


}
