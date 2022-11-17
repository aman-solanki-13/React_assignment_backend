package com.example.reactassignment_backend.repository;

import com.example.reactassignment_backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query(value = "INSERT INTO cart (bought_by, quantity, product_id) VALUES (?2, 1, ?1)", nativeQuery = true)
    void addProductToCartTable(Long productId, String userEmail);
}
