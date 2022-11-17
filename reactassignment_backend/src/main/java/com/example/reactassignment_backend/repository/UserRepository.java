package com.example.reactassignment_backend.repository;

import com.example.reactassignment_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {

}
