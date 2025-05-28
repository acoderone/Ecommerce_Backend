package com.Ecommerce.Ecommerce.dto;

import com.Ecommerce.Ecommerce.models.Cart;
import com.Ecommerce.Ecommerce.models.Role;


import java.util.UUID;


public class UserResponseDTO {
    private UUID id;
    private String name;
    private String phone_number;
    private String email;
    private Role role;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
