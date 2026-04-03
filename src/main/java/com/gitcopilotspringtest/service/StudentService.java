package com.gitcopilotspringtest.service;

import com.gitcopilotspringtest.entity.Student;
import com.gitcopilotspringtest.exception.DuplicateStudentException;
import com.gitcopilotspringtest.exception.StudentNotFoundException;
import com.gitcopilotspringtest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Add a new student to the database
     * @param student Student object to be added
     * @return Saved student object
     * @throws DuplicateStudentException if student with same roll number exists
     */
    public Student addStudent(Student student) {
        if (student.getRollNo() == null || student.getRollNo().isEmpty()) {
            throw new IllegalArgumentException("Roll number cannot be null or empty");
        }

        studentRepository.findByRollNo(student.getRollNo()).ifPresent(s -> {
            throw new DuplicateStudentException("Student with roll number " + student.getRollNo() + " already exists");
        });

        return studentRepository.save(student);
    }

    /**
     * Find student by ID
     * @param id Student ID
     * @return Student object
     * @throws StudentNotFoundException if student not found
     */
    public Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
    }

    /**
     * Find student by roll number
     * @param rollNo Student roll number
     * @return Student object
     * @throws StudentNotFoundException if student not found
     */
    public Student findStudentByRollNo(String rollNo) {
        return studentRepository.findByRollNo(rollNo)
                .orElseThrow(() -> new StudentNotFoundException("Student with roll number " + rollNo + " not found"));
    }

    /**
     * Get all students
     * @return List of all students
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Delete student by ID
     * @param id Student ID
     * @return Success message
     * @throws StudentNotFoundException if student not found
     */
    public String deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));

        studentRepository.delete(student);
        return "Student with id " + id + " has been deleted successfully";
    }

    /**
     * Update student details
     * @param id Student ID
     * @param student Updated student object
     * @return Updated student object
     * @throws StudentNotFoundException if student not found
     */
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));

        if (student.getName() != null) {
            existingStudent.setName(student.getName());
        }
        if (student.getMarks() != null) {
            existingStudent.setMarks(student.getMarks());
        }

        return studentRepository.save(existingStudent);
    }
}

