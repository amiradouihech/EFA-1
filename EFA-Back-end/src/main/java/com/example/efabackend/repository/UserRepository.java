package com.example.efabackend.repository;

import com.example.efabackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
=======

public interface UserRepository extends JpaRepository {
    User findByUsername(String username);
>>>>>>> 65d17af56a3b79fa1fd431e0fdea078d96e5d355
}
