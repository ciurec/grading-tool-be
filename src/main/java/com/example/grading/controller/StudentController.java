package com.example.grading.controller;

import com.example.grading.core.StudentService;
import com.example.grading.dto.CreateStudentDto;
import com.example.grading.dto.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {

        return this.studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody CreateStudentDto studentDto) {
        StudentDto createdStudent = this.studentService.createStudent(studentDto);
        return ResponseEntity.ok(createdStudent);
    }
}
