package com.vta.shop.order.service;

import com.vta.shop.order.domain.Order;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderService {
    Order create(Order order);

    Order  getById(Long id);

    List<Order> getUserOrders(String userId);

    List<Order> getOrders();

    Order changeStatus(Long id, Map<String, String> updatedValues);

}
