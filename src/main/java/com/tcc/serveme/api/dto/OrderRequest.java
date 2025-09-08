package com.tcc.serveme.api.dto;

import com.tcc.serveme.api.model.OrderTicket;
import java.time.LocalDateTime;
import java.util.List;

public record OrderRequest(int tableNumber, String waiter, List<OrderTicket> items, String notes, LocalDateTime createdAt) {}