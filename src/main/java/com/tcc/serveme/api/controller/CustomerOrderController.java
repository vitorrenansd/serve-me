package com.tcc.serveme.api.controller;

import com.tcc.serveme.api.dto.CustomerOrderRequest;
import com.tcc.serveme.api.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class CustomerOrderController {
    private final CustomerOrderService orderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/send")
    public void send(@RequestBody CustomerOrderRequest request) { // change this method from void to OrderRequest when the API is done --Vitor Dias
        orderService.sendOrder(request);
    }
}