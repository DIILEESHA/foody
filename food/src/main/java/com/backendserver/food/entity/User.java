package com.backendserver.food.entity;


import jakarta.persistence.*;

 

@Entity

@Table(name = "users")

public class User {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

 

    @Column(nullable = false)

    private String name;

 

    @Column(nullable = false, unique = true)

    private String username;

 

    @Column(nullable = false)

    private String password;

 

    private String profilePicture;

 

    private String bio;

 

    @Column(nullable = false, unique = true)

    private String email;

 

    @Column(name = "phone_number")

    private String phoneNumber;

 

    public User() {

    }

 

    public User(String name, String username, String password, String email) {

        this.name = name;

        this.username = username;

        this.password = password;

        this.email = email;

    }

 

    // Getters and setters...

 

    public Long getId() {

        return id;

    }

 

    public void setId(Long id) {

        this.id = id;

    }

 

    public String getName() {

        return name;

    }

 

    public void setName(String name) {

        this.name = name;

    }

 

    public String getUsername() {

        return username;

    }

 

    public void setUsername(String username) {

        this.username = username;

    }

 

    public String getPassword() {

        return password;

    }

 

    public void setPassword(String password) {

        this.password = password;

    }

 

    public String getProfilePicture() {

        return profilePicture;

    }

 

    public void setProfilePicture(String profilePicture) {

        this.profilePicture = profilePicture;

    }

 

    public String getBio() {

        return bio;

    }

 

    public void setBio(String bio) {

        this.bio = bio;

    }

 

    public String getEmail() {

        return email;

    }

 

    public void setEmail(String email) {

        this.email = email;

    }

 

    public String getPhoneNumber() {

        return phoneNumber;

    }

 

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;

    }

}
