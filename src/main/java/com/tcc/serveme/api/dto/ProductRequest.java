package com.tcc.serveme.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(

    @NotBlank(message = "Product name is required")
    @JsonProperty("nameProduct")
    String nameProduct,

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be positive")
    Double price

) {}
