package com.example.reactassignment_backend.repository;

import com.example.reactassignment_backend.entities.OrderHistory;
import com.example.reactassignment_backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

    @Modifying
    @Query(value = "INSERT INTO order_history (bought_by, quantity, product_id) VALUES (?2, 1, ?1)", nativeQuery = true)
    void saveProductsToOrderHistoryTable(Long productId, String userEmail);


}
