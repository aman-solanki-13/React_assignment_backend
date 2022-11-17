package com.example.reactassignment_backend.controller;

import com.example.reactassignment_backend.entities.OrderHistory;
import com.example.reactassignment_backend.entities.Product;
import com.example.reactassignment_backend.service.OrderHistoryService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orderHistory")
public class OrderHistoryController {


    @Autowired
    private OrderHistoryService orderHistoryService;



    @PostMapping(value = "saveProductsToOrderHistoryTable/{userEmail}")
    void saveProductsToOrderHistoryTable(@RequestParam("productID") Long[] productIds, @PathVariable("userEmail") String userEmail){
        Arrays.stream(productIds).forEach((productId) -> orderHistoryService.saveProductsToOrderHistoryTable(productId, userEmail));
    }

    @GetMapping("/getCompleteOrderHistoryOfUser/{userEmail}")
    List<Product> getCompleteOrderHistoryOfUser(@PathVariable("userEmail") String userEmail){
        return orderHistoryService.getAllProductsOfUserFromOrderHistory(userEmail);
    }
}
