package com.example.reactassignment_backend.repository;

import com.example.reactassignment_backend.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
