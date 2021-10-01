package com.vta.shop.cart.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_item")
public class CartItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "count", nullable = false)
    private int count;
}
