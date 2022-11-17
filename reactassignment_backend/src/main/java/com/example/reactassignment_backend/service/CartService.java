package com.example.reactassignment_backend.service;

import com.example.reactassignment_backend.entities.Cart;
import com.example.reactassignment_backend.entities.Product;

import java.util.List;

public interface CartService {

    List<Product> allCartProductsOfUser(String userEmail);
}
