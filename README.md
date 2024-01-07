# Training-Center-Management-Backend

This repository contains the backend code for [Training Center Management App]. It is built with Spring Boot, utilizing Spring Security for authentication, JWT for token-based authorization, PostgreSQL for the database, and Swagger UI for API documentation.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Configuration](#configuration)
  - [Database Setup](#database-setup)
  - [Build and Run](#build-and-run)
- [Database Schema](#database-schema)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [Contributors](#contributors)

## Technologies Used

- **Spring Boot:** A Java-based framework for building enterprise-level applications.
  - [Spring Boot](https://spring.io/projects/spring-boot)

- **Spring Security:** Provides comprehensive security services for Java EE-based enterprise software applications.
  - [Spring Security](https://spring.io/projects/spring-security)

- **JWT (JSON Web Tokens):** A compact, URL-safe means of representing claims to be transferred between two parties.
  - [JWT](https://jwt.io/)

- **PostgreSQL:** A powerful, open-source object-relational database system.
  - [PostgreSQL](https://www.postgresql.org/)

- **Swagger UI:** An interactive API documentation tool that helps with API discovery and testing.
  - [Swagger UI](https://swagger.io/tools/swagger-ui/)

- **Other Dependencies:** Include any additional libraries or tools used in your project.

Feel free to click on the provided links to learn more about each technology.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Git](https://git-scm.com/)

### Configuration

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/Training-Center-Management-Backend.git
    ```

2. Navigate to the project directory:

    ```bash
    cd Training-Center-Management-Backend
    ```

3. Open `src/main/resources/application.properties` and configure the database connection and other settings.

### Database Setup

1. Create a PostgreSQL database for the application.

2. Update the database configuration in `application.properties`:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your-database-name
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```

### Build and Run

Build and run the application using Maven:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

## Database Schema

![Database Schema](src/main/resources/static/training_center.png)

This image provides a visual representation of the database schema used in the Training Center Management App.


## API Documentation

The application is accessible at [http://localhost:8080](http://localhost:8080).

API documentation is available using Swagger UI. After starting the application, visit:

[Swagger UI - http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Explore and test the API endpoints using Swagger UI.



## Contributing

Thank you for considering contributing to this project! Contributions are welcome from anyone.

### How to Contribute

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/your-feature-name`.
3. Commit your changes: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature/your-feature-name`.
5. Submit a pull request.

### Contributors

- [Mounir ayad](https://github.com/ad-munir)
- [Abdeljebar Hinda](https://github.com/HINDA-Abdeljebar)
- [Abdellatif El qarrychy](https://github.com/abdellatif300)


Feel free to reach out to any of the contributors for questions or collaboration.

If you are not one of the main contributors listed above, we still encourage you to contribute! We appreciate your help in making this project better.
