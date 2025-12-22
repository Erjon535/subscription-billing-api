package com.erjon.billing.api.plans.dto;

import jakarta.validation.constraints.*;

public record CreatePlanRequest(
        @NotBlank String name,
        @Min(1) int amountCents,
        @NotBlank @Size(min = 3, max = 3) String currency
) { }
