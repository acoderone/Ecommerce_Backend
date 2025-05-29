package com.Ecommerce.Ecommerce.dto;

import com.Ecommerce.Ecommerce.models.Cart;
import com.Ecommerce.Ecommerce.models.Order;
import com.Ecommerce.Ecommerce.models.Role;
import java.util.List;
import java.util.UUID;



public class UserRequestDTO {
    private Integer id;
    private String password;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;

    private Role role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
