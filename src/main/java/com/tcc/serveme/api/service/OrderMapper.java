package com.tcc.serveme.api.service;

import com.tcc.serveme.api.dto.*;
import com.tcc.serveme.model.*;
import java.util.List;

public class OrderMapper {

    public static OrderTicket toEntity(OrderRequest dto, List<Order> order) {
        return new OrderTicket(
            dto.table(),
            dto.waiter(),
            order
        );
    }

    private static Order toEntity(OrderItems dto, Product product) {
        return new Order(
            product, 
            dto.quantity(),
            dto.notes()
        );
    }
}