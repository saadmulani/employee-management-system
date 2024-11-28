# Employee Management System

This project is a **Spring Boot** application designed to manage employees and departments within an organization. It provides a robust RESTful API for managing both entities, along with an intuitive web interface.

---

## Features

- **Employee Management**: CRUD operations for managing employees.
- **Department Management**: CRUD operations for managing departments.
- **Database Integration**: PostgreSQL for persistent data storage.
- **API Documentation**: Fully documented APIs with **Springdoc OpenAPI**.

- **DevTools**: Hot-reloading for faster development iterations.

- **Model Mapping**: Simplifies object transformations using **ModelMapper**.

---

## Tech Stack

- **Programming Language**: Java 21
- **Framework**: Spring Boot 3.4.0
- **Database**: PostgreSQL (with Liquibase for version control)
- **API Documentation**: Springdoc OpenAPI
- **ORM**: Spring Data JPA (Hibernate)
- **Dependency Management**: Maven
- **Object Mapping**: ModelMapper
- **Testing**: Spring Boot Test
- **Tools**:
  - **Lombok** for reducing boilerplate code.
  - **DevTools** for hot-reloading during development.
  - **Swagger UI** for interactive API documentation.

---

## Build and Run

### Prerequisites

Ensure you have the following installed:

1. **Java 21 or later**
2. **Maven** (latest version recommended)
3. **PostgreSQL** (Ensure a running instance with the appropriate configuration)

### Configuring PostgreSQL Database for the Employee Management System

Before running the **Employee Management System** application, ensure the following steps are completed:

**Create a Database in PostgreSQL**

- Open your PostgreSQL client or command line.
- Create a new database with the desired name (e.g., `dbname`).

```sql
CREATE DATABASE employeemanagementsystem;
```

---

### Build the Project

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/employee-management-system.git
   cd employee-management-system
   ```

2. **Install dependencies**:
   ```bash
   mvn clean install
   ```

---

### Run the Application

#### Using Maven

1. **Run the application using Maven**:

   ```bash
   mvn spring-boot:run
   ```

2. Access the application:

   - **API Documentation**: [http://localhost:8080/docs](http://localhost:8080/docs)

---

#### Using Java Command-Line Arguments

1. **Package the application**:

   ```bash
   mvn package
   ```

2. **Run the application with a custom profile or properties**:

   ```bash
   java -jar target/employee-management-system-0.0.1-SNAPSHOT.jar
   ```

   Example: Custom Database Configuration

You can pass custom database properties as command-line arguments:

```bash
java -jar target/employee-management-system-0.0.1-SNAPSHOT.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/dbname --spring.datasource.username=your_username --spring.datasource.password=your_password

```

3. Access the application:
   - **API Documentation**: [http://localhost:8080/docs](http://localhost:8080/docs)

---

---

### Default Database Configuration

Ensure your `application.properties` file contains the following settings (replace placeholders with your values):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/employeemanagementsystem
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```
