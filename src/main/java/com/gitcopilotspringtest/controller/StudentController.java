package com.gitcopilotspringtest.controller;

import com.gitcopilotspringtest.entity.Student;
import com.gitcopilotspringtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Add a new student
     * @param student Student object to be added
     * @return ResponseEntity with saved student and HTTP status
     */
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Student added successfully");
        response.put("data", savedStudent);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Get student by ID
     * @param id Student ID
     * @return ResponseEntity with student data and HTTP status
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getStudent(@PathVariable Long id) {
        Student student = studentService.findStudentById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", student);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Get student by roll number
     * @param rollNo Student roll number
     * @return ResponseEntity with student data and HTTP status
     */
    @GetMapping("/rollno/{rollNo}")
    public ResponseEntity<Map<String, Object>> getStudentByRollNo(@PathVariable String rollNo) {
        Student student = studentService.findStudentByRollNo(rollNo);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", student);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Get all students
     * @return ResponseEntity with list of all students and HTTP status
     */
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("count", students.size());
        response.put("data", students);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Delete student by ID
     * @param id Student ID
     * @return ResponseEntity with success message and HTTP status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable Long id) {
        String message = studentService.deleteStudent(id);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", message);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Update student details
     * @param id Student ID
     * @param student Updated student object
     * @return ResponseEntity with updated student and HTTP status
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Student updated successfully");
        response.put("data", updatedStudent);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

