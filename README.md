# Git Copilot MCP Test

A Spring Boot application created for testing GitHub Copilot with MCP (Model Context Protocol) integration.

## Project Overview

This is a Spring Boot 4.0.5 project that demonstrates a basic RESTful web service setup with Spring Web framework.

## Technologies Used

- **Spring Boot:** 4.0.5
- **Java:** 17 (or compatible version)
- **Build Tool:** Maven 3.6+ (or mvn wrapper)
- **Language:** Java
- **Database:** H2 (In-memory)

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.6+ or higher (or use the included Maven wrapper)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/pawan-231/git_copilot_mcp_test.git
cd git_copilot_mcp_test
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Project Structure

```
src/
├── main/
│   ├── java/com/gitcopilotspringtest/
│   │   └── GitcopilotspringtestApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/gitcopilotspringtest/
        └── GitcopilotspringtestApplicationTests.java
```

## Available Commands

- **Build the project:**
  ```bash
  mvn clean install
  ```

- **Run the application:**
  ```bash
  mvn spring-boot:run
  ```

- **Run tests:**
  ```bash
  mvn test
  ```

- **Package the application:**
  ```bash
  mvn package
  ```

- **Clean build artifacts:**
  ```bash
  mvn clean
  ```

## References

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/4.0.5/reference/index.html)
- [Spring Web Reference](https://docs.spring.io/spring-boot/4.0.5/reference/web/servlet.html)
- [Maven Documentation](https://maven.apache.org/guides/index.html)
- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)

## License

This project is open source and available under the MIT License.

## Author

Created with GitHub Copilot MCP

---

For more information, visit the [project repository](https://github.com/pawan-231/git_copilot_mcp_test)

