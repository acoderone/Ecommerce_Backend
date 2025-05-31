package com.Ecommerce.Ecommerce.repository;

import com.Ecommerce.Ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
