# Student Management API Documentation

## Overview
This API provides endpoints for managing student records with features like adding, retrieving, updating, and deleting students.

## Database
- **Database:** H2 (In-memory relational database)
- **Access Console:** http://localhost:8080/h2-console
- **Database URL:** jdbc:h2:mem:testdb
- **Username:** sa
- **Password:** (blank)

## API Endpoints

### 1. Add Student
- **Endpoint:** `POST /api/students/add`
- **Description:** Add a new student to the database
- **Request Body:**
```json
{
  "name": "John Doe",
  "rollNo": "STU001",
  "marks": 85.5
}
```
- **Success Response (201 Created):**
```json
{
  "status": "success",
  "message": "Student added successfully",
  "data": {
    "id": 1,
    "name": "John Doe",
    "rollNo": "STU001",
    "marks": 85.5
  }
}
```
- **Error Response (409 Conflict - Duplicate Roll No):**
```json
{
  "status": "error",
  "error": "CONFLICT",
  "message": "Student with roll number STU001 already exists",
  "timestamp": "2026-04-04T10:30:00",
  "statusCode": 409
}
```

### 2. Get Student by ID
- **Endpoint:** `GET /api/students/{id}`
- **Description:** Retrieve a student by their ID
- **Example:** `GET /api/students/1`
- **Success Response (200 OK):**
```json
{
  "status": "success",
  "data": {
    "id": 1,
    "name": "John Doe",
    "rollNo": "STU001",
    "marks": 85.5
  }
}
```
- **Error Response (404 Not Found):**
```json
{
  "status": "error",
  "error": "NOT_FOUND",
  "message": "Student with id 999 not found",
  "timestamp": "2026-04-04T10:30:00",
  "statusCode": 404
}
```

### 3. Get Student by Roll Number
- **Endpoint:** `GET /api/students/rollno/{rollNo}`
- **Description:** Retrieve a student by their roll number
- **Example:** `GET /api/students/rollno/STU001`
- **Success Response (200 OK):**
```json
{
  "status": "success",
  "data": {
    "id": 1,
    "name": "John Doe",
    "rollNo": "STU001",
    "marks": 85.5
  }
}
```

### 4. Get All Students
- **Endpoint:** `GET /api/students/all`
- **Description:** Retrieve all students from the database
- **Success Response (200 OK):**
```json
{
  "status": "success",
  "count": 2,
  "data": [
    {
      "id": 1,
      "name": "John Doe",
      "rollNo": "STU001",
      "marks": 85.5
    },
    {
      "id": 2,
      "name": "Jane Smith",
      "rollNo": "STU002",
      "marks": 92.0
    }
  ]
}
```

### 5. Update Student
- **Endpoint:** `PUT /api/students/{id}`
- **Description:** Update student information (name and/or marks)
- **Example:** `PUT /api/students/1`
- **Request Body:**
```json
{
  "name": "John Updated",
  "marks": 88.5
}
```
- **Success Response (200 OK):**
```json
{
  "status": "success",
  "message": "Student updated successfully",
  "data": {
    "id": 1,
    "name": "John Updated",
    "rollNo": "STU001",
    "marks": 88.5
  }
}
```

### 6. Delete Student
- **Endpoint:** `DELETE /api/students/{id}`
- **Description:** Delete a student by their ID
- **Example:** `DELETE /api/students/1`
- **Success Response (200 OK):**
```json
{
  "status": "success",
  "message": "Student with id 1 has been deleted successfully"
}
```
- **Error Response (404 Not Found):**
```json
{
  "status": "error",
  "error": "NOT_FOUND",
  "message": "Student with id 999 not found",
  "timestamp": "2026-04-04T10:30:00",
  "statusCode": 404
}
```

## Exception Handling

The application uses a centralized exception handler (`GlobalExceptionHandler`) with `@ControllerAdvice` annotation to handle all exceptions globally:

| Exception | HTTP Status | Error Type |
|-----------|------------|-----------|
| StudentNotFoundException | 404 | NOT_FOUND |
| DuplicateStudentException | 409 | CONFLICT |
| IllegalArgumentException | 400 | BAD_REQUEST |
| Generic Exception | 500 | INTERNAL_SERVER_ERROR |

## Field Validations

- **name:** Required, cannot be null or empty
- **rollNo:** Required, unique (cannot have duplicates), cannot be null or empty
- **marks:** Required, must be a valid number

## Running the Application

1. Build the project:
```bash
mvn clean install
```

2. Run the application:
```bash
mvn spring-boot:run
```

3. Access H2 Console:
Open browser and navigate to: `http://localhost:8080/h2-console`

4. Test the API using curl, Postman, or any REST client

## Example cURL Commands

### Add Student
```bash
curl -X POST http://localhost:8080/api/students/add \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","rollNo":"STU001","marks":85.5}'
```

### Get All Students
```bash
curl http://localhost:8080/api/students/all
```

### Get Student by ID
```bash
curl http://localhost:8080/api/students/1
```

### Update Student
```bash
curl -X PUT http://localhost:8080/api/students/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"John Updated","marks":88.5}'
```

### Delete Student
```bash
curl -X DELETE http://localhost:8080/api/students/1
```

---

For more information, visit the [project repository](https://github.com/pawan-231/git_copilot_mcp_test)

