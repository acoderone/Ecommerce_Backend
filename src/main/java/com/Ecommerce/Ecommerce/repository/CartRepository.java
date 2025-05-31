package com.Ecommerce.Ecommerce.repository;

import com.Ecommerce.Ecommerce.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart,Long> {
}
