package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUser(){
       List<UserDTO>  userList = userService.getUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getSingleUser(@PathVariable int id){
        UserDTO userDTO = userService.getSingleUser(id);
        return  new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        UserDTO createdUser = userService.saveUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO){
        UserDTO updatedUser = userService.updateUser(id,userDTO);
        return new ResponseEntity<>(updatedUser,HttpStatus.UPGRADE_REQUIRED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        boolean result = userService.deleteUser(id);
        if(result){
            return new ResponseEntity<>("Success",HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>("False",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/users/filter")
    public ResponseEntity<List<UserDTO>> getFilteredUser(@RequestParam("name") String name){
        List<UserDTO>  userList = userService.getFilteredUsers(name);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
