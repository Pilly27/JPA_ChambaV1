package com.upc.jpa_chambav1.dtos;

import com.upc.jpa_chambav1.entities.Role;

import java.util.List;

public class UserDTO {
    private Long id;

    private String username;

    private String password;
    private Boolean enabled;

    private List<Role> roles;
}
