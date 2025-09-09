package com.tcc.serveme.api.controller;

import com.tcc.serveme.api.dto.OrderRequest;
import com.tcc.serveme.api.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // @PostMapping("/send")
    // send order to backend
    // api.model.Order api.service.OrderService
}