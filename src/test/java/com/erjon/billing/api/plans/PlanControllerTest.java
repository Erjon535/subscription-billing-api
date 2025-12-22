package com.erjon.billing.api.plans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PlanControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void createPlan_returns201_andJsonBody() throws Exception {
        var body = """
                {
                  "name": "Starter",
                  "amountCents": 1500,
                  "currency": "eur"
                }
                """;

        mvc.perform(post("/plans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").value("Starter"))
                .andExpect(jsonPath("$.amountCents").value(1500))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    void createPlan_missingName_returns400() throws Exception {
        var body = """
                {
                  "amountCents": 1500,
                  "currency": "EUR"
                }
                """;

        mvc.perform(post("/plans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }
}
