package com.example.efabackend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_Sequence",
            sequenceName ="user_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_Sequence"
    )
    private long id;
    private String name;
    private String role;
    private LocalDate Dob;
    private String email;
    private String Password;


    public User(long id, String name, String role, LocalDate dob, String email, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        Dob = dob;
        this.email = email;
        Password = password;
    }

    public User(String name, String role, LocalDate dob, String email, String password) {
        this.name = name;
        this.role = role;
        Dob = dob;
        this.email = email;
        Password = password;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        Dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

