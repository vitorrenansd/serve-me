package com.tcc.serveme.api.dto;

import com.tcc.serveme.api.model.OrderItem;
import java.time.LocalDateTime;
import java.util.List;

public record OrderRequest(int tableNumber, String waiter, List<OrderItem> items, String notes, LocalDateTime createdAt) {}