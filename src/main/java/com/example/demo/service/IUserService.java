package com.example.demo.service;

import com.example.demo.dto.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getUser();
    UserDTO getSingleUser(int id);
    UserDTO updateUser(int id, UserDTO userDTO);
    boolean deleteUser(int id);
    List<UserDTO> filterUserByName(String name);

    List<UserDTO> filterUserByAddress(String name);
};

