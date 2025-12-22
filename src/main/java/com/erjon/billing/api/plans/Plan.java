package com.erjon.billing.api.plans;

import jakarta.persistence.*;

@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int amountCents;

    @Column(nullable = false, length = 3)
    private String currency;

    protected Plan() { } // JPA

    public Plan(String name, int amountCents, String currency) {
        this.name = name;
        this.amountCents = amountCents;
        this.currency = currency;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAmountCents() { return amountCents; }
    public String getCurrency() { return currency; }
}
