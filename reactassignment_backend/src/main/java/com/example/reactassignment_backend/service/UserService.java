package com.example.reactassignment_backend.service;

import com.example.reactassignment_backend.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUserToDB(User user);
    List<User> getAllUsers();

    User findUserWithEmail(String userEmail);

}
