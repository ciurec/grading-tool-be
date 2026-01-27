package com.example.grading.controller;

import com.example.grading.dto.StudentAssignmentDto;
import com.example.grading.dto.SyncAssignmentDto;
import com.example.grading.service.StudentService;
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

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return this.studentService.getStudentById(id);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody CreateStudentDto studentDto) {
        StudentDto createdStudent = this.studentService.saveStudent(studentDto);
        return ResponseEntity.ok(createdStudent);
    }

    @PutMapping
    public ResponseEntity<StudentDto> editStudent(@RequestBody CreateStudentDto studentDto) {
        StudentDto createdStudent = this.studentService.saveStudent(studentDto);
        return ResponseEntity.ok(createdStudent);
    }


    @PutMapping("/addAssignments")
    public void addAssignments(@RequestBody SyncAssignmentDto assignmentDto) {
        this.studentService.syncAssignment(assignmentDto);

    }

    @PutMapping("/unassign")
    public void unassignAssignments(@RequestBody SyncAssignmentDto assignmentDto) {
        this.studentService.unassignAssignments(assignmentDto);

    }

    @PutMapping("/grade")
    public void gradeStudent(@RequestBody StudentAssignmentDto studentAssignmentDto) {
        this.studentService.gradeStudent(studentAssignmentDto);

    }
}
