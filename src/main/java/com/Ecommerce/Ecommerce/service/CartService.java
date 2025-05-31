package com.Ecommerce.Ecommerce.service;

import com.Ecommerce.Ecommerce.dto.CartRequestDTO;
import com.Ecommerce.Ecommerce.dto.CartResponseDTO;
import com.Ecommerce.Ecommerce.models.Cart;

import com.Ecommerce.Ecommerce.models.CartItem;
import com.Ecommerce.Ecommerce.models.Product;
import com.Ecommerce.Ecommerce.models.User;
import com.Ecommerce.Ecommerce.repository.CartItemRepository;
import com.Ecommerce.Ecommerce.repository.CartRepository;
import com.Ecommerce.Ecommerce.repository.ProductRepository;
import com.Ecommerce.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CartService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;
    public Cart addToCart(CartRequestDTO requestDTO) {
        System.out.println(requestDTO.getUserId());
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("USsssssssser"+user.getId());
        Cart cart=user.getCart();


       Product product=productRepository.findById(requestDTO.getProductId())
               .orElseThrow(()->new RuntimeException("Product not found"));
        List<CartItem>items=cart.getItems();

        CartItem cartItem=new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(requestDTO.getQuantity());
        items.add(cartItem);
        cart.setItems(items);

        cartItemRepository.save(cartItem);

        cartRepository.save(cart);
        return cart;

    }
}
