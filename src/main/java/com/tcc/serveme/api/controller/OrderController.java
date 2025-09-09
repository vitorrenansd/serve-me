package com.tcc.serveme.api.controller;

import com.tcc.serveme.api.dto.OrderRequest;
import com.tcc.serveme.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/send")
    public OrderRequest send(@RequestBody OrderRequest request) {
        // send order to backend
        //return orderService.sendOrder(request)
        return null;
    }
}