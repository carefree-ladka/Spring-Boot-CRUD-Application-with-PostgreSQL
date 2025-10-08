# Spring Boot CRUD Application with PostgreSQL

A simple REST API application built with Spring Boot that performs CRUD (Create, Read, Update, Delete) operations on User entities, using Supabase PostgreSQL as the database.

## Features

- **Create** new users
- **Read** user details (single or all users)
- **Update** existing user information
- **Delete** users
- Input validation for user data
- PostgreSQL database integration via Supabase
- RESTful API endpoints

## Technologies Used

- **Spring Boot** - Application framework
- **Spring Data JPA** - Data persistence
- **PostgreSQL** - Database (via Supabase)
- **Lombok** - Reduce boilerplate code
- **Jakarta Validation** - Input validation
- **Maven** - Dependency management

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Supabase account (for PostgreSQL database)

## Database Setup

### Supabase Configuration

1. Create a free account at [Supabase](https://supabase.com)
2. Create a new project
3. Navigate to Project Settings > Database
4. Copy your connection string details

### Application Properties

Create or update `application.properties` (or `application.yml`) with your Supabase credentials:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://[YOUR-PROJECT-REF].supabase.co:5432/postgres
spring.datasource.username=[YOUR-USERNAME]
spring.datasource.password=[YOUR-PASSWORD]

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Server Configuration
server.port=8080
```

Replace placeholders with your actual Supabase credentials.

## Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd crud-postgressql
```

2. Configure your database credentials in `application.properties`

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Create User
```http
POST /users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

### Get User by ID
```http
GET /users/{id}
```

### Get All Users
```http
GET /users
```

### Update User
```http
PUT /users/users/{id}
Content-Type: application/json

{
  "name": "Jane Doe",
  "email": "jane.doe@example.com"
}
```

### Delete User
```http
POST /users/{id}
```

## Validation Rules

The application enforces the following validation rules:

- **Name**
  - Cannot be empty
  - Maximum 20 characters

- **Email**
  - Cannot be empty
  - Must be a valid email format
  - Maximum 50 characters
  - Must be unique (enforced at database level)

## Sample Request/Response

### Create User Request
```json
{
  "name": "Alice Smith",
  "email": "alice.smith@example.com"
}
```

### Create User Response
```json
{
  "id": 1,
  "name": "Alice Smith",
  "email": "alice.smith@example.com"
}
```

### Validation Error Response
```json
{
  "timestamp": "2024-10-08T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Email should be valid"
}
```

## Project Structure

```
src/main/java/com/example/crud/postgressql/
├── config/
│   └── DataLoader.java           # Loads mock data on startup
├── controller/
│   └── UserController.java       # REST API endpoints
├── entity/
│   └── User.java                 # User entity with validation
├── exception/
│   └── GlobalExceptionHandler.java # Global error handling
├── repository/
│   └── UserRepository.java       # Database operations
└── service/
    └── UserService.java          # Business logic
```

## Dependencies

Key dependencies in `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

## Testing with Postman/cURL

### cURL Examples

**Create User:**
```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@example.com"}'
```

**Get All Users:**
```bash
curl http://localhost:8080/users
```

**Get User by ID:**
```bash
curl http://localhost:8080/users/1
```

**Update User:**
```bash
curl -X PUT http://localhost:8080/users/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"John Updated","email":"john.updated@example.com"}'
```

**Delete User:**
```bash
curl -X POST http://localhost:8080/users/1
```

## Notes

- The application uses `@Valid` annotation to trigger validation
- Email uniqueness is enforced at the database level using `@UniqueConstraint`
- The table will be automatically created by Hibernate when the application starts
- `spring.jpa.hibernate.ddl-auto=update` will update the schema without dropping existing data

## Troubleshooting

### Connection Issues
- Verify your Supabase credentials are correct
- Ensure your Supabase project is active
- Check if your IP address is allowed in Supabase network restrictions

### Validation Errors
- Ensure request body contains valid JSON
- Check that all required fields are provided
- Verify email format and length constraints

## Future Enhancements

- Add pagination for GET all users
- Implement exception handling with custom error responses
- Add logging
- Write unit and integration tests
- Add Swagger/OpenAPI documentation
- Implement DTOs to separate API and entity models

## License

This project is open-source and available for educational purposes.
