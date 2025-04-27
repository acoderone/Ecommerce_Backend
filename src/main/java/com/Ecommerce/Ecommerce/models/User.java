package com.Ecommerce.Ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Order> orders;
    @OneToOne (mappedBy = "user" , cascade = CascadeType.ALL)

    private Cart cart;
}
