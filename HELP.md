# Spring Boot CI/CD Demo

This project is a simple Spring Boot application used to demonstrate CI/CD pipelines with Jenkins and Docker.

## Prerequisites

- **Java 11** or higher
- **Maven** 3.6.3 or higher
- **Docker** installed and running
- **Jenkins** installed and configured

## Project Structure

- `src/main/java`: Contains the source code of the Spring Boot application.
- `src/test/java`: Contains the test cases for the application.
- `pom.xml`: Maven configuration file.

## Running the Application Locally

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/spring-boot-cicd-demo.git
    cd spring-boot-cicd-demo
    ```

2. **Build the project using Maven:**

    ```bash
    mvn clean install
    ```

3. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

   The application will start on `http://localhost:8080`.