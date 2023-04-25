package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements  IUserService{

    //This auto wired annotation used to inject another class
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    //Create new user
    public UserDTO saveUser(UserDTO userDTO){
        try{
           User userCreated = userRepo.save(modelMapper.map(userDTO, User.class));
            return modelMapper.map(userCreated, UserDTO.class);

            //created user id should be filled in respond
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    //Get user list
    public List<UserDTO> getUser(){
        try{
            List<User> userList = new ArrayList<User>();

            userList = userRepo.findAll();

            if (userList.isEmpty()) {
                throw new ResourceNotFoundException("Not found data");
            }
            return  modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    //get single user
    public UserDTO getSingleUser(int id){
        Optional<User> singleUser  = userRepo.findById(id);

        System.out.println(singleUser);
        if(singleUser.isPresent()){
            return modelMapper.map(singleUser, UserDTO.class);
        }else{
            throw new ResourceNotFoundException("Not found data");
        }
    }

    //Update user
    public UserDTO updateUser(int id, UserDTO userDTO){
       try{

           Optional<User> user = userRepo.findById(id);

           if(user.isPresent()){
              User updatedUser = userRepo.save(modelMapper.map(userDTO, User.class));
               return modelMapper.map(updatedUser, UserDTO.class);
           }
           throw new RuntimeException("Item not found");

       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
    }

    //Delete user
    public boolean deleteUser(int id){
       try{
          userRepo.deleteById(id);
           return true;
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
    }

    //Filter user by name
    public List<UserDTO> filterUserByName(String name){
        System.out.println("at getFilteredUsers");
        try{

            List<User> userList = new ArrayList<User>();

            userList = userRepo.findByNameContainingIgnoreCase(name);
            System.out.println(userList);

            if (userList.isEmpty()) {
                System.out.println("empty");
                throw new ResourceNotFoundException("Not found data");
            }
            System.out.println(userList.get(0).getId()+userList.get(0).getAddress()+userList.get(0).getName());
            System.out.println("complete");
            return  modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<UserDTO> filterUserByAddress(String name){
        System.out.println("at getFilteredUsers");
        try{

            List<User> userList = new ArrayList<User>();

            userList = userRepo.findByAddress(name);
            System.out.println(userList);

            if (userList.isEmpty()) {
                System.out.println("empty");
                throw new ResourceNotFoundException("Not found data");
            }
            System.out.println(userList.get(0).getId()+userList.get(0).getAddress()+userList.get(0).getName());
            System.out.println("complete");
            return  modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
