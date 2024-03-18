package com.example.efabackend.service.impl;

import com.example.efabackend.Dto.LoginDto;
import com.example.efabackend.Dto.RegisterDto;
import com.example.efabackend.Repo.userRepo;
import com.example.efabackend.entity.User;
import com.example.efabackend.response.LoginResponse;
import com.example.efabackend.response.RegisterResponse;
import com.example.efabackend.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userImpl implements userService {

    @Autowired
    private userRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse addUser(RegisterDto registerDto) {
        User existingUser = userRepo.findByEmail(registerDto.getEmail());
        if (existingUser != null) {
            return new RegisterResponse("User with email " + registerDto.getEmail() + " already exists",false);
        }
        User user = new User(
                registerDto.getId(),
                registerDto.getEmail(),
                passwordEncoder.encode(registerDto.getPassword()),
                registerDto.getName(),
                registerDto.getRole()
        );
        userRepo.save(user);
        return new RegisterResponse("User added",true);
    }


    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        User user = userRepo.findByEmail(loginDto.getEmail());

        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user.getPassword();

            if (passwordEncoder.matches(password, encodedPassword)) {
                return new LoginResponse("Login Success", true);
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email Not Exists", false);
        }
    }





}
