package com.example.efabackend.service;

import com.example.efabackend.Dto.LoginDto;
import com.example.efabackend.Dto.RegisterDto;
import com.example.efabackend.entity.User;
import com.example.efabackend.response.LoginResponse;
import com.example.efabackend.response.RegisterResponse;

public interface userService {

     RegisterResponse addUser(RegisterDto registerDTO);
     LoginResponse loginUser (LoginDto loginDto);
}
