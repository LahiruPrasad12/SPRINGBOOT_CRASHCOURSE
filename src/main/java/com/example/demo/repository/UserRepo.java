package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Mekt pass krl tiyenne Entity ek and eke primary id type ek
public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findByNameContainingIgnoreCase(String name);
}
