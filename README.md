\# Subscription Billing API



A \*\*Spring Boot REST API\*\* that exposes core billing operations for a subscription-based system.

This project builds on the domain logic from `subscription-billing-system` and focuses on

\*\*API design, validation, persistence, and testability\*\*.



This is a backend-only service intended for learning and portfolio purposes.



---



\## What This API Does



The API provides HTTP endpoints to manage billing-related resources such as:



* Subscription plans
* Customers
* (Future) subscriptions, invoices, and payments



It is designed with:

* Clear separation between \*\*domain logic\*\* and \*\*API layer\*\*
* Validation at the boundary (request DTOs)
* Simple persistence using Spring Data JPA
* Fast, repeatable tests



---



\## Current Features



\### Plans

* Create a billing plan
* List all plans



Each plan contains:

* Name
* Monthly price (in cents)
* Currency (ISO code)



---



\## Example API Usage



\### Create a Plan



```bash

curl -X POST http://localhost:8080/plans \\

&nbsp; -H "Content-Type: application/json" \\

&nbsp; -d '{

&nbsp;   "name": "Starter",

&nbsp;   "amountCents": 1500,

&nbsp;   "currency": "EUR"

&nbsp; }'

```





Response:

```json

{

&nbsp; "id": 1,

&nbsp; "name": "Starter",

&nbsp; "amountCents": 1500,

&nbsp; "currency": "EUR"

}

```



\### List Plans



```bash

curl http://localhost:8080/plans

```



Response:

```json

\[

&nbsp; {

&nbsp;   "id": 1,

&nbsp;   "name": "Starter",

&nbsp;   "amountCents": 1500,

&nbsp;   "currency": "EUR"

&nbsp; }

]

```



\## Tech Stack



* Java 17



* Spring Boot



* Spring Web



* Spring Data JPA



* Jakarta Validation



* H2 (in-memory database)



* Maven (via Maven Wrapper)



* JUnit 5





\## Running the Application



\### Requirements



Java 17+





\### Start the app

Windows (PowerShell):



.\\mvnw.cmd spring-boot:run



macOS / Linux:



./mvnw spring-boot:run



The API will start at:



http://localhost:8080





\## Running Tests



./mvnw test



All tests run against an in-memory database and do not require external services.



\## Project Structure

&nbsp;

```text

&nbsp;src/

&nbsp;├─ main/

&nbsp;│   ├─ java/

&nbsp;│   │   └─ com.erjon.billing.api

&nbsp;│   │       ├─ plans        # controllers, entities, repositories

&nbsp;│   │       └─ domain       # shared domain models

&nbsp;│   └─ resources/

&nbsp;│       └─ application.properties

&nbsp;└─ test/

&nbsp;    └─ java/

&nbsp;        └─ controller tests

```



\## Relationship to Other Repositories



This project is part of a larger portfolio:



* \*\*subscription-billing-system\*\*

Pure domain + business logic (no framework)



* \*\*subscription-billing-api\*\* (this repo)

REST API layer exposing billing operations



* \*\*transaction-ledger\*\*

Financial transaction tracking and correctness modeling



Together, these demonstrate layered backend system design.





\## Future Improvements



Customer endpoints



Subscriptions \& invoices



Payment processing



Idempotency at the API layer



Database-backed persistence



Authentication \& authorization



OpenAPI / Swagger documentation




## Author



Built by Erjon as a portfolio project demonstrating backend system design,

API construction, and test-driven development.

