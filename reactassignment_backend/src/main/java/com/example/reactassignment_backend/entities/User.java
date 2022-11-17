package com.example.reactassignment_backend.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userDetails")
public class User{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName", nullable = false)
    private String name;

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "password")
    private String password;

}
