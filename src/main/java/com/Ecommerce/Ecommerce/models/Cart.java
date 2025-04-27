package com.Ecommerce.Ecommerce.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
