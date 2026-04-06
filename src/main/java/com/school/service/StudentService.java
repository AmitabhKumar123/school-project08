package com.school.service;

import com.school.model.Student;
import com.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // Save Student
 /*   public Student saveStudent(Student s) {
        return repo.save(s);
    }
    
    */
    
    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }
    public Student saveStudent(Student s) {
        System.out.println("Service layer called: saveStudent");
        return repo.save(s);
    }
    // Get All Students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Delete Student
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    // Update Student
    public Student updateStudent(Long id, Student newStudent) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

        student.setName(newStudent.getName());
        student.setClassName(newStudent.getClassName());
        student.setEmail(newStudent.getEmail());

        return repo.save(student);
    }
    
    
}