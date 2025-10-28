package com.tcc.serveme.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderItems(

    @NotNull(message = "Product id is required")
    @Valid
    Long productId,

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    Integer quantity,

    String notes

) {}
