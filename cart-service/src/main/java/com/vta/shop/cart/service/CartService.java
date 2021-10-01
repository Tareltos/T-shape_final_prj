package com.vta.shop.cart.service;

import java.util.List;

import com.vta.shop.cart.domain.CartItem;

public interface CartService {

    List<CartItem> getCartItems(String userId);

    List<CartItem> updateCart(String userId, List<CartItem> cartItem);
}
