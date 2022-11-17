package com.example.reactassignment_backend.service.impl;

import com.example.reactassignment_backend.entities.OrderHistory;
import com.example.reactassignment_backend.entities.Product;
import com.example.reactassignment_backend.exception.ProductNotFoundException;
import com.example.reactassignment_backend.repository.OrderHistoryRepository;
import com.example.reactassignment_backend.repository.ProductRepository;
import com.example.reactassignment_backend.service.OrderHistoryService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderHistoryImpl implements OrderHistoryService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;




    @Override
    public void saveProductsToOrderHistoryTable(Long productId, String userEmail) {
        orderHistoryRepository.saveProductsToOrderHistoryTable(productId, userEmail);
    }

    @Override
    public List<Product> getAllProductsOfUserFromOrderHistory(String userName) {
        List<OrderHistory> allHistoryItemsOfUser = orderHistoryRepository.findAll().stream().filter((orderHistory) -> orderHistory.getBoughtBy().equals(userName)).toList();
        List<Long> allProductsOfUserFromOrderHistoryIds= allHistoryItemsOfUser.stream().map(OrderHistory::getProductId).toList();

        System.out.println(allProductsOfUserFromOrderHistoryIds);

        List<Product> products = allProductsOfUserFromOrderHistoryIds.stream().map((id) -> productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product","Id", id))).collect(Collectors.toList());

        return  products;

    }

}
