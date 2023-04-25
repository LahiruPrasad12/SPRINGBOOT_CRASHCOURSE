package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Mekt pass krl tiyenne Entity ek and eke primary id type ek
public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findByNameContainingIgnoreCase(String name);

    @Query(value = "SELECT * FROM users WHERE address = ?1", nativeQuery = true)
    List<User> findByAddress(String name);
}

// What are the inbuilt methods that JpaRepository type will provide
// How to bind a SQL query to a method written in Jpa repository