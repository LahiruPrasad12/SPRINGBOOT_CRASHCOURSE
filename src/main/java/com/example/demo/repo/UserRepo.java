package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Mekt pass krl tiyenne Entity ek and eke primary id type ek
public interface UserRepo extends JpaRepository<User,Integer> {

}
