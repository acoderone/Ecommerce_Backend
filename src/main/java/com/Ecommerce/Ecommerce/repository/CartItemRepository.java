package com.Ecommerce.Ecommerce.repository;

import com.Ecommerce.Ecommerce.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
