package com.tcc.serveme.api.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int tableNumber;
    private String waiter;
    private List<OrderItem> items;
    private String notes;
    private LocalDateTime createdAt;
}