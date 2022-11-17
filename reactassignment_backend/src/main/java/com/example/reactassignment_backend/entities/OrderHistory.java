package com.example.reactassignment_backend.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "orderHistory")
@Table(name = "orderHistory")
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "boughtBy")
    private String boughtBy;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "productId")
    private Long productId;



}
