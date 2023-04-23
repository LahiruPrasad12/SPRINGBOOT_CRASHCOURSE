package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Me tiken krnne paaveni ek default constructor ek, devanai ek parameteriz cinstructor ek and avasana ek getters and settern ve
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String name;
    private String address;
}
