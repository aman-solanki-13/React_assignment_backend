package com.example.reactassignment_backend.controller;

import com.example.reactassignment_backend.entities.OrderHistory;
import com.example.reactassignment_backend.entities.User;
import com.example.reactassignment_backend.service.ProductService;
import com.example.reactassignment_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
//    private ProductService productService;

//    @Autowired
//    public UserController(ProductService productService) {
//        this.productService = productService;
//    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Build create user rest API

    @PostMapping("/userSignup")
//    public User saveUser(@RequestBody User user){
//        return userService.saveUserToDB(user);
//    }
    public ResponseEntity<User> saveUserToDb(@RequestBody User user){
        System.out.println(user);
        return new ResponseEntity<User>(userService.saveUserToDB(user), HttpStatus.CREATED);
    }

    // Build get all user rest API
    @GetMapping("/getAllUsersList")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    // Build to find user by Email
    @GetMapping("/findUser/{userEmail}")
    public ResponseEntity<User> getUserById(@PathVariable("userEmail") String userEmail) {
        return new ResponseEntity<User>(userService.findUserWithEmail(userEmail), HttpStatus.OK);
    }

//    @GetMapping("/userOrderHistory/{userEmail}")
//    List<OrderHistory> getUserOrderHistory(@PathVariable("userEmail") String userEmail){
//        return pro
//    }


}
