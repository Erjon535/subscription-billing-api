package com.erjon.billing.api.plans;

import com.erjon.billing.api.plans.dto.CreatePlanRequest;
import com.erjon.billing.api.plans.dto.PlanResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plans")
public class PlanController {
    private final PlanRepository plans;

    public PlanController(PlanRepository plans) {
        this.plans = plans;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlanResponse create(@Valid @RequestBody CreatePlanRequest req) {
        var plan = plans.save(new Plan(req.name(), req.amountCents(), req.currency().toUpperCase()));
        return new PlanResponse(plan.getId(), plan.getName(), plan.getAmountCents(), plan.getCurrency());
    }
}
