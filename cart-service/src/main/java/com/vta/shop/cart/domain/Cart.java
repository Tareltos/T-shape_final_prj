package com.vta.shop.cart.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cart {

    private long id;
    private String userId;
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private List<CartItem> items;

}
