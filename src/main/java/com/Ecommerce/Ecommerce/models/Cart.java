package com.Ecommerce.Ecommerce.models;

import jakarta.persistence.*;

import java.util.List;

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
