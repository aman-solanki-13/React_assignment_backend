package com.example.reactassignment_backend.controller;

import com.example.reactassignment_backend.entities.Product;
import com.example.reactassignment_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAllProducts")
    List<Product> getAllProducts(){
      return productService.getAllProducts();
    }

    @GetMapping("/getProductWithId/{productId}")
    Product getProductWithId(@PathVariable("productId") Long productId){
        return productService.getProductById(productId);
    }

    @PostMapping("/addProductToCart/{productId}/{userEmail}")
    void addProductToCart(@PathVariable("productId") Long productId, @PathVariable("userEmail") String userEmail){
         productService.addProductToCartTable(productId, userEmail);
    }



}
