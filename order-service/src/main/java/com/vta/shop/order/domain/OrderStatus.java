package com.vta.shop.order.domain;

import java.util.Arrays;

public enum OrderStatus {
    OPEN("Open"), APPROVED("Approved"), CONFIRMED("Confirmed"), SENT("Sent"),
    COMPLETED("Completed"), CANCELLED("Cancelled");

    private String value;

    OrderStatus(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }

    static OrderStatus getValue(String value) {

        return Arrays.stream(OrderStatus.values())
                .filter(orderStatus -> orderStatus.getValue().equalsIgnoreCase(value))
                .findFirst().orElse(OrderStatus.OPEN);

    }
}
