package com.tcc.serveme.api.service;

import com.tcc.serveme.api.dto.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrder {
    
    public void sendOrder(OrderRequest request) {
        // Placeholder
        System.out.println(request);
    }
}