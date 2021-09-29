package com.vta.shop.cart.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vta.shop.cart.domain.Cart;
import com.vta.shop.cart.domain.CartItem;


@Service
@Transactional
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {

        this.cartRepository = cartRepository;
    }


    @Override
    public Cart getCart(String userId) {

        return cartRepository.getByUserId(userId)
                .orElse(cartRepository.save(Cart.builder().userId(userId).build()));
    }

    @Override
    public void addItem(Long cartId, CartItem cartItem) {

        Cart cart = cartRepository.getById(cartId);
        cart.getItems().add(cartItem);
        cartRepository.save(cart);
    }

    @Override
    public void deleteItem(Long cartId, Long cartItemId) {

        Cart cart = cartRepository.getById(cartId);
        List<CartItem> cartItems = cart.getItems().stream().filter(i -> !i.getId().equals(cartItemId))
                .collect(Collectors.toList());

        cart.getItems().clear();
        cart.getItems().addAll(cartItems);
        cartRepository.save(cart);
    }

    @Override
    public void updateCount(Long cartId, Long itemId, Integer count) {

        Cart cart = cartRepository.getById(cartId);
        cart.getItems().stream().filter(i -> i.getId().equals(itemId))
                .findFirst().ifPresent(cartItem -> {
            cartItem.setCount(count);
        });
        cartRepository.save(cart);
    }
}
