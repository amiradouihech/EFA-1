package com.example.efabackend.repository;

import com.example.efabackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository {
    User findByUsername(String username);
}
