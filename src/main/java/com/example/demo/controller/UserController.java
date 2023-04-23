package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin
public class UserController {

    @GetMapping("/")
    public String getUser(){
        return "User";
    }

    @PostMapping("/")
    public String saveUser(){
        return "save user";
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
