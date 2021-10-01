package com.vta.shop.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<CartItem> getCartItems(String userId) {

        return this.cartRepository.getByUserId(userId);
    }

    @Override
    public List<CartItem> updateCart(String userId, List<CartItem> cartItems) {

        List<CartItem> items = this.cartRepository.getByUserId(userId);
        List<CartItem> toSave = cartItems.stream().filter(item -> Objects.isNull(item.getId()))
                .collect(Collectors.toList());

        Map<Long, CartItem> toUpdate = cartItems.stream().filter(item -> Objects.nonNull(item.getId()))
                .collect(Collectors.toMap(CartItem::getId, Function
                        .identity()));

        List<CartItem> toDelete = new ArrayList<>();

        items.forEach(persisted -> {
                    Optional<CartItem> updated = Optional.ofNullable(toUpdate.get(persisted.getId()));
                    if (updated.isPresent()) {
                        persisted.setCount(updated.get().getCount());
                        toSave.add(persisted);
                    } else {
                        toDelete.add(persisted);
                    }
                }
        );
        this.cartRepository.deleteAll(toDelete);

        return this.cartRepository.saveAll(toSave);
    }
}
