package com.vta.shop.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vta.shop.cart.domain.CartItem;
import com.vta.shop.cart.service.CartService;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {

        this.cartService = cartService;
    }

    @GetMapping
    public List<CartItem> getCartItems(@RequestParam("userId") String userId) {

        return cartService.getCartItems(userId);
    }

    @PutMapping
    public List<CartItem> update(@RequestParam("userId") String userId, @RequestBody List<CartItem> cartItem) {

        return cartService.updateCart(userId, cartItem);
    }

}
