# 📦 Spring Boot Inventory Project

This is a backend application built with **Java and Spring Boot**, designed to manage products and categories in an inventory system. It follows RESTful principles, includes full CRUD support, and uses Swagger UI for automatic API documentation.

---

## 🧭 Project Purpose

The goal of this project is to offer a real-world, educational example of a clean and modular Spring Boot application that demonstrates best practices in REST API development.

---

## 🚀 Technologies Used

| Tech                | Purpose                            |
|---------------------|-------------------------------------|
| Java 21             | Programming language                |
| Spring Boot 3.5.0   | Backend application framework       |
| Spring Web          | REST API building                   |
| Spring Data JPA     | ORM and database interaction        |
| PostgreSQL          | Relational database                 |
| Lombok              | Boilerplate reduction               |
| Maven               | Dependency management               |
| Springdoc OpenAPI   | Swagger-based API documentation     |

---

## 📂 Modules

### 📌 Product
- Create, read, update, delete (CRUD)
- Filter by category

### 📌 Category
- Manage product categories
- One-to-Many relationship

### ⚙️ Validation & Error Handling
- Java Bean Validation annotations (`@Valid`, `@NotNull`, etc.)
- Global exception handler with `@ControllerAdvice`

### 📚 Swagger Integration
- Interactive UI for testing and documenting endpoints

---

## 🔧 How to Run

### Clone and Navigate

```bash
git clone https://github.com/Rauf-Alkan/spring-boot-Inventory-project.git
cd spring-boot-Inventory-project
