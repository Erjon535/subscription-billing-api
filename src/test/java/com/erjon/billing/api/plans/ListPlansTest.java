package com.erjon.billing.api.plans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ListPlansTest {

    @Autowired
    MockMvc mvc;

    @Test
    void listPlans_returnsCreatedPlan() throws Exception {
        // create a plan first
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
                .andExpect(status().isCreated());

        // then list plans
        mvc.perform(get("/plans").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$[0].id", not(emptyString())))
                .andExpect(jsonPath("$[0].name", is("Starter")))
                .andExpect(jsonPath("$[0].amountCents", is(1500)))
                .andExpect(jsonPath("$[0].currency", is("EUR")));
    }
}
