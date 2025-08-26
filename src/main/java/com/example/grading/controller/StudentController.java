package com.example.grading.controller;

import com.example.grading.core.StudentService;
import com.example.grading.datamodel.StudentDatamodel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDatamodel> getAllStudents() {

        return this.studentService.getAllStudents();
    }
}
