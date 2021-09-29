package com.vta.shop.cart.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vta.shop.cart.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

   Optional<Cart> getByUserId(String userId);

}
