package com.example.reactassignment_backend.service.impl;

import com.example.reactassignment_backend.entities.User;
import com.example.reactassignment_backend.exception.UserNotFoundCustomException;
import com.example.reactassignment_backend.repository.UserRepository;
import com.example.reactassignment_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUserToDB(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserWithEmail(String userEmail) {
        Optional<User> user =  userRepository.findById(userEmail);

        return userRepository.findById(userEmail).orElseThrow(() -> new UserNotFoundCustomException("User", "Email", userEmail));
    }



//    @Override
//    public User findUserWithEmail(String userEmail) {
//        return "Found";
//    }


}
