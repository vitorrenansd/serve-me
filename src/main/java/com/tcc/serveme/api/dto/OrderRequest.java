package com.tcc.serveme.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.serveme.api.model.OrderTicket;

public record OrderRequest(String waiter, @JsonProperty("orderTicket") OrderTicket ordertTicket, String notes) {}