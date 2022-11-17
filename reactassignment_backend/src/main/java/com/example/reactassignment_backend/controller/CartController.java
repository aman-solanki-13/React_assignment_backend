package com.example.reactassignment_backend.controller;

import com.example.reactassignment_backend.entities.Product;
import com.example.reactassignment_backend.service.CartService;
import com.example.reactassignment_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/getAllCartItemByUserEmail/{userEmail}")
    List<Product> allCartProductsOfUser(@PathVariable("userEmail") String userEmail){
        return cartService.allCartProductsOfUser(userEmail);
    }


}
