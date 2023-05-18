package com.backendserver.food.service;

 

import com.backendserver.food.entity.User;

import com.backendserver.food.repository.UserRepository;

import org.springframework.stereotype.Service;

 

import java.util.Optional;

 

@Service

public class UserService {

    private final UserRepository userRepository;

 

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

 

    public Optional<User> getUserProfile(Long userId) {

        return userRepository.findById(userId);

    }

 

    public void updateUserProfile(Long userId, User updatedProfile) {

        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {

            User user = existingUser.get();

            user.setName(updatedProfile.getName());

            user.setUsername(updatedProfile.getUsername());

            user.setPassword(updatedProfile.getPassword());

            user.setProfilePicture(updatedProfile.getProfilePicture());

            user.setBio(updatedProfile.getBio());

            user.setEmail(updatedProfile.getEmail());

            user.setPhoneNumber(updatedProfile.getPhoneNumber());

            userRepository.save(user);

        }

    }

 

    public User createUser(User user) {

        return userRepository.save(user);

    }

 

    public Optional<User> findByUserName(String userName) {

        return userRepository.findByUsername(userName);

    }

 

    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);

    }

}

 