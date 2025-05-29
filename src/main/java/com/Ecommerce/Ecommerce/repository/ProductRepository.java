package com.Ecommerce.Ecommerce.repository;

import com.Ecommerce.Ecommerce.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Item,Long> {
}
