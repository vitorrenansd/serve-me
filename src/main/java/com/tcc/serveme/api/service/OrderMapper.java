package com.tcc.serveme.api.service;

import com.tcc.serveme.api.dto.*;
import com.tcc.serveme.api.model.*;

import java.util.List;

public class OrderMapper {

    public static Order toEntity(OrderRequest dto, List<Item> items) {
        return new Order(
            dto.table(),
            dto.waiter(),
            items
        );
    }

    private static Item toEntity(OrderItems dto, Product product) {
        return new Item(
            product, 
            dto.quantity(),
            dto.notes()
        );
    }
}