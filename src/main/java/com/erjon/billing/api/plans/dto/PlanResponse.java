package com.erjon.billing.api.plans.dto;

import com.erjon.billing.api.plans.Plan;

public record PlanResponse(
        String id,
        String name,
        int amountCents,
        String currency
) {
    public static PlanResponse from(Plan plan) {
        return new PlanResponse(
                plan.getId(),
                plan.getName(),
                plan.getAmountCents(),
                plan.getCurrency()
        );
    }
}
