package com.Ecommerce.Ecommerce.repository;

import com.Ecommerce.Ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User>findByEmail(String email);
    Optional<User>findById(Long id);

}
