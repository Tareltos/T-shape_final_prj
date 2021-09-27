package com.vta.shop.order.controller;

import com.vta.shop.order.domain.Order;
import com.vta.shop.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {

        return orderService.getById(id);
    }

    @PatchMapping("/{id}/status")
    public Order getOrder(@PathVariable Long id, @RequestBody Map<String, String> updatedValues) {

        return orderService.changeStatus(id, updatedValues);
    }

    @GetMapping
    public List<Order> getUserOrders(@RequestHeader String userName) {

        return orderService.getUserOrders(userName);
    }

    @GetMapping("/all")
    public List<Order> getUserOrders() {

        return orderService.getOrders();
    }

    @PostMapping
    public Order create(@Valid @RequestBody Order order) {

        return orderService.create(order);
    }

}