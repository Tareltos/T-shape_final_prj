package com.vta.shop.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vta.shop.cart.domain.CartItem;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> getByUserId(String userId);

}
