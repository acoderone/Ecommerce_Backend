package com.Ecommerce.Ecommerce.controller;

import com.Ecommerce.Ecommerce.dto.CartRequestDTO;
import com.Ecommerce.Ecommerce.dto.CartResponseDTO;
import com.Ecommerce.Ecommerce.models.Cart;
import com.Ecommerce.Ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/addToCart")
    public Cart addToCart(@RequestBody CartRequestDTO requestDTO){
        return cartService.addToCart(requestDTO);

    }
}
