package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Me tiken krnne paaveni ek default constructor ek, devanai ek parameteriz cinstructor ek and avasana ek getters and settern ve
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class UserDTO {
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 5, max = 10)
    private String address;
}
