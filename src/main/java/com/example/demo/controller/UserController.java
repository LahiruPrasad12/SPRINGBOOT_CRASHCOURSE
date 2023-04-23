package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUser(){
        return "User";
    }

    @PostMapping("/")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        return userService.saveUser(userDTO);

    }

    @PutMapping("/")
    public String updateUser(){
        return "save user";
    }

    @DeleteMapping("/")
    public String deleteUser(){
        return "delete user";
    }
}
