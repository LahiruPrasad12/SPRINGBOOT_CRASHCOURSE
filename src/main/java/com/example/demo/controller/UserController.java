package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Validated
@CrossOrigin
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUser(){
        logger.info("at getUser");
       List<UserDTO>  userList = userService.getUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getSingleUser(@PathVariable int id){
        UserDTO userDTO = userService.getSingleUser(id);
        return  new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserDTO userDTO){
        //how to check if the requested body compatible with the UserDTO
        //use the @valid annotation to map the payload to userDTO
        UserDTO createdUser = userService.saveUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody @Valid UserDTO userDTO){
        //how to check if the requested body compatible with the UserDTO
        UserDTO updatedUser = userService.updateUser(id,userDTO);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        boolean result = userService.deleteUser(id);
        if(result){
            return new ResponseEntity<>("Success",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("False",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/users/filter/name")
    public ResponseEntity<List<UserDTO>> filterUserByName1(@RequestParam("name") @NotBlank String name){
        System.out.println(name.isEmpty());

        List<UserDTO>  userList = userService.filterUserByName(name);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/users/filter/name/required")
    public ResponseEntity<List<UserDTO>> filterUserByName2(@RequestParam(required = true)  String name){
        List<UserDTO>  userList = userService.filterUserByName(name);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/users/filter/address")
    public ResponseEntity<List<UserDTO>> filterUserByAddress(@RequestParam("address")  String name){
        List<UserDTO>  userList = userService.filterUserByAddress(name);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    //in the context of request param what is the usage of required = true ?
    // what's the usage of @NotNull
}
