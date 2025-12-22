package com.erjon.billing.api.plans.dto;

public record PlanResponse(
        String id,
        String name,
        int amountCents,
        String currency
) { }
