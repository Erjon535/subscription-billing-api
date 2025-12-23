package com.erjon.billing.api.plans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plans")
public class PlanEntity {

    @Id
    private String id;

    private String name;
    private int amountCents;
    private String currency;

    protected PlanEntity() {
        // JPA
    }

    public PlanEntity(String id, String name, int amountCents, String currency) {
        this.id = id;
        this.name = name;
        this.amountCents = amountCents;
        this.currency = currency;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAmountCents() { return amountCents; }
    public String getCurrency() { return currency; }
}
