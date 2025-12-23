package com.erjon.billing.api.plans;

import com.erjon.billing.api.plans.dto.CreatePlanRequest;
import com.erjon.billing.api.plans.dto.PlanResponse;
import com.erjon.billing.domain.Plan;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        // domain object (pure)
        Plan domain = Plan.monthly(req.name(), req.amountCents(), req.currency().toUpperCase());

        // persistence entity
        var entity = new PlanEntity(
                UUID.randomUUID().toString(),
                domain.name(),
                domain.amountCents(),
                domain.currency()
        );

        var saved = plans.save(entity);
        return new PlanResponse(saved.getId(), saved.getName(), saved.getAmountCents(), saved.getCurrency());
    }

    @GetMapping
    public List<PlanResponse> listPlans() {
        return plans.findAll()
                .stream()
                .map(p -> new PlanResponse(p.getId(), p.getName(), p.getAmountCents(), p.getCurrency()))
                .toList();
    }
}
