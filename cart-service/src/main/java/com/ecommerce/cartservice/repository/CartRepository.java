package com.ecommerce.cartservice.repository;

import com.ecommerce.cartservice.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    void deleteByCustomerId(Long customerId);
    Cart findByCustomerId(Long customerId);
}
