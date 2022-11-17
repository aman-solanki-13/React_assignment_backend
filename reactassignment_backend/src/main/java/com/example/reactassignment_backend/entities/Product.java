package com.example.reactassignment_backend.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "productList")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productPrice")
    private int productPrice;

    @Column(name = "productQuantity")
    private int productQuantity;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productCategory")
    private String productCategory;
}
