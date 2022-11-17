package com.example.reactassignment_backend.service;

import com.example.reactassignment_backend.entities.OrderHistory;
import com.example.reactassignment_backend.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderHistoryService {
    void saveProductsToOrderHistoryTable(Long productId, String userEmail);

    List<Product> getAllProductsOfUserFromOrderHistory(String userName);

}
