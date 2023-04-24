package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserDTO> getUser(){
        return userService.getUser();
    }

    @PostMapping("/")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        return userService.saveUser(userDTO);

    }

    @PutMapping("/")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }
}
