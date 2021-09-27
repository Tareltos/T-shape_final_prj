package com.vta.shop.order.service;

import com.vta.shop.order.domain.Order;
import com.vta.shop.order.domain.StatusHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {

        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getById(Long id) {

        return orderRepository.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getUserOrders(String userId) {

        return orderRepository.getOrdersByUserId(userId).orElse(new ArrayList<>());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrders() {

        return orderRepository.findAll();
    }

    @Override
    public Order changeStatus(Long id, Map<String, String> updatedValues) {

        Order order = orderRepository.getById(id);
        order.getStatusHistory().add(getStatusHistory(order));
        order.setStatus(updatedValues.get("status"));
        order.setComment(updatedValues.get("comment"));

        return orderRepository.save(order);

    }

    private StatusHistory getStatusHistory(Order order) {

        StatusHistory statusHistory = new StatusHistory();
        statusHistory.setStatus(order.getStatus());
        statusHistory.setComment(order.getComment());
        statusHistory.setUpdatedAt(LocalDateTime.now());
        return statusHistory;
    }
}
