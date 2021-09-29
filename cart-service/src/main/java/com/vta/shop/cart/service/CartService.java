package com.vta.shop.cart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vta.shop.cart.domain.Cart;
import com.vta.shop.cart.domain.CartItem;

public interface CartService {

    Cart getCart(String userId);

    void addItem(Long cartId, CartItem cartItem);

    void deleteItem(Long cartId, Long cartItem);

    void updateCount(Long cartId, Long itemId, Integer count);


}
