package com.gitcopilotspringtest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle StudentNotFoundException
     * @param exception StudentNotFoundException
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, Object>> handleStudentNotFoundException(StudentNotFoundException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("error", "NOT_FOUND");
        response.put("message", exception.getMessage());
        response.put("timestamp", LocalDateTime.now());
        response.put("statusCode", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle DuplicateStudentException
     * @param exception DuplicateStudentException
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(DuplicateStudentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, Object>> handleDuplicateStudentException(DuplicateStudentException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("error", "CONFLICT");
        response.put("message", exception.getMessage());
        response.put("timestamp", LocalDateTime.now());
        response.put("statusCode", HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    /**
     * Handle IllegalArgumentException
     * @param exception IllegalArgumentException
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("error", "BAD_REQUEST");
        response.put("message", exception.getMessage());
        response.put("timestamp", LocalDateTime.now());
        response.put("statusCode", HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle generic Exception
     * @param exception Exception
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("error", "INTERNAL_SERVER_ERROR");
        response.put("message", "An unexpected error occurred: " + exception.getMessage());
        response.put("timestamp", LocalDateTime.now());
        response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

