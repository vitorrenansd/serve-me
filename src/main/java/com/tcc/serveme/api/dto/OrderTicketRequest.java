package com.tcc.serveme.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record OrderTicketRequest(

    Integer id,

    @NotNull(message = "Table is required")
    @Min(value = 1, message = "Table must be at least 1")
    Integer table,

    @NotNull(message = "Client is required")
    @Valid
    ClientRequest client,

    @NotNull(message = "Order list is required")
    @Valid
    List<OrderItemRequest> order

) {}
