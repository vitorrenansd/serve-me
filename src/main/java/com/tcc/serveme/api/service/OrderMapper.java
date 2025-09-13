package com.tcc.serveme.api.service;

import com.tcc.serveme.api.dto.*;
import com.tcc.serveme.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderTicket toEntity(OrderRequest dto) {
        OrderTicketRequest ticketDto = dto.orderTicket();

        List<Order> orders = ticketDto.order().stream()
                .map(OrderMapper::toEntity)
                .collect(Collectors.toList());

        return new OrderTicket(
                ticketDto.id(),
                ticketDto.table(),
                new Client(ticketDto.client().name()),
                orders
        );
    }

    private static Order toEntity(OrderItemRequest dto) {
        ProductRequest p = dto.product();
        Product product = new Product(p.nameProduct(), p.price());
        return new Order(product, dto.quantity());
    }
}
