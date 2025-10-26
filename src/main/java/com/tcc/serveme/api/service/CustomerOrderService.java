package com.tcc.serveme.api.service;

import com.tcc.serveme.api.dto.CustomerOrderRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {
    
    public void sendOrder(CustomerOrderRequest request) {
        // Placeholder
        System.out.println(request);
    }
}