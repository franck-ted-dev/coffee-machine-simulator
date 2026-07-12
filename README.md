# ☕ Coffee Machine Simulator
![Maven CI](https://github.com/franck-ted-dev/coffee-machine-simulator/actions/workflows/maven.yml/badge.svg)

A console-based coffee machine simulator developed in **Java 21** with a strong focus on **object-oriented design**, **layered architecture**, **testability**, and **clean-code principles**.

This project started as a programming exercise and was gradually refactored into a maintainable Java application following professional development practices.

---

## Features

* Buy different coffee drinks (Espresso, Latte, Cappuccino)
* Fill machine resources
* Take collected money
* Display current machine inventory
* Input validation
* Layered architecture
* Comprehensive unit tests
* Maven build management
* Code coverage analysis with JaCoCo

---

## Technologies

* Java 21
* Maven
* JUnit 5
* JaCoCo
* Git

---

## Project Structure

```text
src
├── main
│   └── java
│       └── machine
│           ├── controller
│           ├── domain
│           ├── request
│           ├── response
│           ├── service
│           └── ui
│   
│
└── test
    └── java
        └── machine
```

### Package Responsibilities

| Package      | Responsibility                                                        |
| ------------ | --------------------------------------------------------------------- |
| `domain`     | Core business entities (`Drink`, `Stock`, `CashUnit`, `DrinkCatalog`) |
| `service`    | Business logic of the application                                     |
| `controller` | Coordinates user interactions and delegates work to services          |
| `ui`         | Console input/output and message formatting                           |
| `request`    | Immutable request objects (`record`)                                  |
| `response`   | Immutable response objects (`record`)                                 |

---

## Architecture

The application follows a layered architecture.

```text
                 CoffeeMachine
                       │
                       ▼
            CoffeeMachineController
                       │
       ┌───────────────┼───────────────┬────────────────────┐
       ▼               ▼               ▼                    ▼
  BuyService      FillService     TakeService     ResourceInventoryService
       │               │               │                    │
       └───────────────┴───────────────┴────────────────────┘
                               │
                               ▼
                          Domain Layer
```

Business logic is completely separated from the console UI, making the services easy to test independently.

---

## Design Decisions

During development, the project was continuously refactored with maintainability in mind.

Implemented improvements include:

* Separation of UI and business logic
* Layered architecture
* Immutable request/response DTOs using Java records
* Dependency injection through constructors
* Small classes with a single responsibility
* Business logic isolated inside services
* Consistent package organization
* Unit testing of business logic

---

## Running the Application

Clone the repository

```bash
git clone https://github.com/franck-ted-dev/coffee-machine-simulator.git
```

Navigate into the project

```bash
cd coffee-machine-simulator
```

Run

```bash
mvn clean compile exec:java
```

(or run `Main.java` directly from your IDE)

---

## Running the Tests

Build the application, run all tests, and generate the JaCoCo report:

```bash
mvn clean verify
```

Open

```text
target/site/jacoco/index.html
```

---

## Test Coverage

The project contains unit tests covering the application's business logic, including:

* Drink preparation
* Resource validation
* Buying drinks
* Filling resources
* Taking money
* Inventory retrieval
* Domain validation

The focus is not on achieving 100% coverage but on testing meaningful business behavior.

---

## What I Learned

This project helped me deepen my understanding of professional Java development.

Key learning outcomes include:

* Object-Oriented Programming
* Layered Architecture
* Separation of Concerns
* Dependency Injection
* Clean Code principles
* Unit Testing with JUnit 5
* Maven project management
* Code Coverage with JaCoCo
* Refactoring techniques
* Git workflow and versioning

---

## Future Improvements

Possible future extensions include:

* Logging
* Persistence
* Configuration files
* Graphical User Interface
* REST API using Spring Boot

These features were intentionally left out of version **1.0.0** to keep the project focused on software design and maintainability.

---

## Author

**Franck Divane Tedjou Kamla**

Computer Science Student at TU Dortmund

GitHub: https://github.com/franck-ted-dev
