package com.vta.shop.order.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

}
