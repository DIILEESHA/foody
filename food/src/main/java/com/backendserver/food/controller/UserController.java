package com.backendserver.food.controller;

 

import com.backendserver.food.entity.User;

import com.backendserver.food.service.UserService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

 

import java.util.Optional;

 

@RestController

@RequestMapping("/api/users")

public class UserController {

    private final UserService userService;

 

    public UserController(UserService userService) {

        this.userService = userService;

    }

 

    @GetMapping("/{userId}/profile")

    public ResponseEntity<?> getUserProfile(@PathVariable Long userId) {

        Optional<User> user = userService.getUserProfile(userId);

        if (user.isPresent()) {

            return ResponseEntity.ok(user.get());

        }

        return ResponseEntity.notFound().build();

    }

 

    @PutMapping("/{userId}/profile")

    public ResponseEntity<?> updateUserProfile(@PathVariable Long userId, @RequestBody User updatedProfile) {

        Optional<User> user = userService.getUserProfile(userId);

        if (user.isPresent()) {

            userService.updateUserProfile(userId, updatedProfile);

            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();

    }

 

    @PostMapping("/signup")

    public ResponseEntity<?> signUp(@RequestBody User user) {

        Optional<User> existingUser = userService.findByUserName(user.getUsername());

        if (existingUser.isPresent()) {

            return ResponseEntity.badRequest().body("User already exists");

        }

        User newUser = userService.createUser(user);

        return ResponseEntity.ok(newUser);

    }

    @DeleteMapping("/{userId}")

    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {

        Optional<User> user = userService.getUserProfile(userId);

        if (user.isPresent()) {

            userService.deleteUser(userId);

            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();

    }

}