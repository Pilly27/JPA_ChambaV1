package com.upc.jpa_chambav1.dtos;

import com.upc.jpa_chambav1.entities.User;
    
public class RoleDTO {
    private Long id;

    private String rol;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
