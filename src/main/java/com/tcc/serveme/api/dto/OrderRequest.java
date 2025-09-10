package com.tcc.serveme.api.dto;

import java.util.List;

public record OrderRequest(int tableNumber, String waiter, List<Integer> items, String notes) {}