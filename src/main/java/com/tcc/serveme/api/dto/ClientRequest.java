package com.tcc.serveme.api.dto;

import jakarta.validation.constraints.NotBlank;

public record ClientRequest(

    @NotBlank(message = "Client name is required")
    String name

) {}
