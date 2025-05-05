🐾 Pet Store Application

This is a simple Spring Boot application that simulates a pet store, where users can "buy" pets based on their budget. It includes a REST API, JPA entities, services, and integration tests.

🚀 Features

    Create and list users

    Create and list pets

    Users can buy available pets if they have enough budget

    Tracks ownership of pets

    Purchase history endpoint

    Includes integration tests for core scenarios

🛠️ Tech Stack

    Java 17+

    Spring Boot

    Spring Data JPA

    H2 In-Memory Database (default)

    JUnit 5 (for tests)

📦 Setup Instructions

Clone the repository
    
    git clone https://github.com/your-username/petstore.git
    cd petstore

    Build and run

    ./mvnw spring-boot:run

    The application will start on http://localhost:8080.

All endpoints below have been verified via Postman:

Method  Endpoint                                  Description

POST    http://localhost:8080/api/users/create    Create 10 random users

GET     http://localhost:8080/api/users/list      List all users

POST    http://localhost:8080/api/pets/create     Create 20 random pets

GET     http://localhost:8080/api/pets/list       List all pets

POST    http://localhost:8080/api/pets/buy        Attempt to buy pets

GET     http://localhost:8080/api/pets/history    List purchase history

✅ Running Tests

./mvnw test

🧪 Test Coverage

Test Name                       Description

testBuyPetNotEnoughBudget()     Verifies that a user with insufficient funds cannot buy any pet

testBuyPetAlreadyOwned()        Ensures a pet already owned by another user cannot be bought again
