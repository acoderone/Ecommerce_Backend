package com.Ecommerce.Ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;
    private String item_name;
    private String description;
    private Integer price;
    private String category;
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
