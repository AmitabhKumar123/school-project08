package com.school.controller;

import com.school.model.Student;
import com.school.service.StudentService;
import com.school.dto.ApiResponse;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // ✅ Add Student
    @PostMapping
    public ApiResponse<Student> addStudent(@Valid @RequestBody Student s) {
        return new ApiResponse<>(200, "Student added successfully", service.saveStudent(s));
    }

    // ✅ Get All Students
    @GetMapping
    public ApiResponse<List<Student>> getAllStudents() {
        return new ApiResponse<>(200, "Students fetched successfully", service.getAllStudents());
    }

    // ✅ Get Student by ID
    @GetMapping("/{id}")
    public ApiResponse<Student> getStudentById(@PathVariable Long id) {
        return new ApiResponse<>(200, "Student fetched successfully", service.getStudentById(id));
    }

    // ✅ Update Student
    @PutMapping("/{id}")
    public ApiResponse<Student> updateStudent(@PathVariable Long id, @RequestBody Student s) {
        return new ApiResponse<>(200, "Student updated successfully", service.updateStudent(id, s));
    }

    // ✅ Delete Student
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return new ApiResponse<>(200, "Student deleted successfully", null);
    }
}