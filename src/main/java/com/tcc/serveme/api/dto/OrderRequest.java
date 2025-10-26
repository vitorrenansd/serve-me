package com.tcc.serveme.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record OrderRequest(

    @NotBlank(message = "Waiter is required")
    String waiter,

    @NotNull(message = "Table is required")
    @Min(value = 1, message = "Table must be at least 1")
    Integer table,

    @NotNull(message = "OrderItems is required")
    @Size(min = 1, message = "Order must have at least one item")
    @Valid
    @JsonProperty("orderItems")
    List<OrderItems> orderItems

) {}