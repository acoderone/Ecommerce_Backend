package com.Ecommerce.Ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne (mappedBy = "user" , cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private Cart cart_id;
}
