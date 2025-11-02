package com.tcc.serveme.api.service;

import com.tcc.serveme.api.dto.*;
import com.tcc.serveme.api.model.*;

import java.util.List;

public class OrderMapper {

    public static Orders toEntity(OrderRequest dto, List<OrderItem> items) {
        return new Orders(
            dto.table(),
            dto.waiter(),
            items
        );
    }

    public static OrderItem toEntity(OrderItems dto, Product product) {
        return new OrderItem(
            product, 
            dto.quantity(),
            dto.notes()
        );
    }
}