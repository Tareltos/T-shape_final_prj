package com.vta.shop.cart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vta.shop.cart.domain.Cart;
import com.vta.shop.cart.domain.CartItem;
import com.vta.shop.cart.service.CartService;

@RestController("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {

        this.cartService = cartService;
    }

    @GetMapping
    public Cart getCart(@RequestParam String userId) {

        return cartService.getCart(userId);
    }

    @PostMapping("/{cartId}")
    public void addItem(@PathVariable Long cartId, @RequestBody CartItem cartItem) {

        cartService.addItem(cartId, cartItem);
    }


    @DeleteMapping("/{cartId}/items/{itemId}")
    public void deleteItem(@PathVariable Long cartId, @PathVariable Long itemId) {

        cartService.deleteItem(cartId, itemId);
    }

    @PutMapping("/{cartId}/items/{itemId}")
    public void deleteItem(@PathVariable Long cartId, @PathVariable Long itemId, @RequestParam Integer count) {

        cartService.updateCount(cartId, itemId, count);
    }
}
