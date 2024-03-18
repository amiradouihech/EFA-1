package com.example.efabackend.service.impl;

import com.example.efabackend.Dto.userDto;
import com.example.efabackend.Repo.userRepo;
import com.example.efabackend.entity.User;
import com.example.efabackend.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userImpl implements userService {
    @Autowired
    private userRepo userRepo;

    @Autowired
    private PasswordEncoder PasswordEncoder;


    @Override
    public String addUser(userDto userDTO) {
        User user=new User(
                userDTO.getId(),
                userDTO.getEmail(),
                this.PasswordEncoder.encode(userDTO.getPassword()),
                userDTO.getName(),
                userDTO.getRole()
        );
        userRepo.save(user);
        return user.getName();
    }
}
