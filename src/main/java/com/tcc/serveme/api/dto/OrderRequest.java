package com.tcc.serveme.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(

    @NotBlank(message = "Waiter is required")
    String waiter,

    @NotNull(message = "OrderTicket is required")
    @Valid
    @JsonProperty("orderTicket")
    OrderTicketRequest orderTicket,

    String notes

) {}
