This project is a comprehensive banking application developed in Java, designed to provide essential functionalities for account management. It includes RESTful APIs for account creation, deposit, withdrawal, retrieval, and deletion. The project also features a mapping functionality to convert between DTOs (Data Transfer Objects) and entities using the AccountMapper class. Built with Spring Boot framework and Spring Data JPA, the application leverages Hibernate for ORM (Object-Relational Mapping) to interact with the database efficiently.

Tech Stack:

Java
Spring Boot
Spring Data JPA
Hibernate
RESTful API

Some REST API's:

Add data via rest client
Api url: http://localhost:8080/api/accounts
Http Method :POST

For all data info in database:
API= http://localhost:8080/api/accounts

Deposit information
API = http://localhost:8080/api/accounts/1/deposit
Http Method:GET

Withdraw information
API= http://localhost:8080/api/accounts/1/withdraw
Http Method:GET
