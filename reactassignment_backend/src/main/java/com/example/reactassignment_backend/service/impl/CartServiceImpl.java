package com.example.reactassignment_backend.service.impl;

import com.example.reactassignment_backend.entities.Cart;
import com.example.reactassignment_backend.entities.Product;
import com.example.reactassignment_backend.exception.ProductNotFoundException;
import com.example.reactassignment_backend.repository.CartRepository;
import com.example.reactassignment_backend.repository.ProductRepository;
import com.example.reactassignment_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

//    @Autowired
//    public CartServiceImpl(CartRepository cartRepository) {
//        this.cartRepository = cartRepository;
//    }

    @Override
    public List<Product> allCartProductsOfUser(String userEmail) {
         List<Cart> allCartItemsOfUser = cartRepository.findAll().stream().filter((cartItem) -> cartItem.getBoughtBy().equals(userEmail)).toList();
         List<Product> allUserCarProducts = null;

         List<Long> ids = allCartItemsOfUser.stream().map(Cart::getProductId).collect(Collectors.toList());

         return ids.stream().map((id) -> productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product", "Id", id))).collect(Collectors.toList());

    }
}
