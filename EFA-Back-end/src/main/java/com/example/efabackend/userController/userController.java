package com.example.efabackend.userController;

import com.example.efabackend.Dto.userDto;
import com.example.efabackend.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class userController {
    @Autowired
    private userService userservice;
    @PostMapping(path = "/register")
    public String register(@RequestBody userDto UserDTO){
        String id =userservice.addUser(UserDTO);
        return id;
    }
}
