
# SkillHub Backend

This is the backend API for **SkillHub**, a professional learning platform for connecting users and courses, built using **Java**, **Spring Boot**, and **MariaDB**.

## ✅ Features

- User registration and login (JWT-based authentication)
- Password encryption using BCrypt
- Role-based access control (planned)
- Swagger documentation (OpenAPI v3)
- Modular architecture (DTOs, Services, Repositories, Config, Security)
- Maven as build system

## 📦 Tech Stack

- Java 17+
- Spring Boot 3
- Spring Security (JWT, filters, authentication)
- Spring Data JPA
- MariaDB
- Maven
- Swagger / OpenAPI 3
- Postman (for testing)
- Docker (planned)
- Redis & MongoDB (future integrations)
- Terraform for Oracle Cloud infrastructure (IaC)

## 🚀 Getting Started

### Requirements

- Java 17+
- Maven
- MariaDB running locally or remotely
- IntelliJ IDEA or VSCode (recommended)

### Environment Variables

Create a file named `.env` or use `application.properties`:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/skillhub_db
spring.datasource.username=your_user
spring.datasource.password=your_password

jwt.secret=your_jwt_secret_key
jwt.expiration=86400000
```

### Setup

```bash
# Clone the repo
git clone https://github.com/your-username/skillhub-backend.git
cd skillhub-backend

# Run the application
./mvnw spring-boot:run
```

> The database tables will be automatically created if `spring.jpa.hibernate.ddl-auto=update` is enabled.

## 📑 API Documentation

Once the server is running, visit:

```
http://localhost:8080/swagger-ui/index.html
```

You can log in and authorize protected endpoints using the `Authorize` button (JWT token required).

## 🔒 Authentication

- POST `/api/auth/login`: returns JWT token
- POST `/api/users/register`: user registration
- All other endpoints require Authorization header:  
  `Authorization: Bearer <your_token>`

## 🔧 Maven Commands

```bash
# Compile
./mvnw clean compile

# Run tests
./mvnw test

# Package as JAR
./mvnw package
```

## 🗃️ Project Structure

```
com.skillhub.skillhub
├── config            # SecurityConfig, SwaggerConfig, etc.
├── controller        # REST controllers
├── dto               # Data Transfer Objects
├── model             # Entity classes
├── repository        # JPA Repositories
├── security          # JWT filters and UserDetails service
├── service           # Business logic, including JwtService
```

## ✅ Roadmap (Next Steps)

- Enable user roles and permissions
- Redis caching for performance
- MongoDB microservice for feedback and user activity
- Terraform scripts for Oracle Cloud
- Dockerization
- Unit and integration tests

## 👤 Author

- Santiago Gabriel Cabrera - https://github.com/SntXHub
- Student and backend developer focused on professional fullstack development

---

> 🧠 *Keep learning. Build clean. Deploy smart.*
