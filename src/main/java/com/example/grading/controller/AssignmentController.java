package com.example.grading.controller;

import com.example.grading.dto.CreateAssignmentDto;
import com.example.grading.dto.EditAssignmentDto;
import com.example.grading.dto.StudentDto;
import com.example.grading.service.AssignmentService;
import com.example.grading.dto.AssignmentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping
    public List<AssignmentDto> getAllAssignments() {

        return this.assignmentService.getAllAssignements();
    }

    @GetMapping("/{id}")
    public AssignmentDto getAssignmentById(@PathVariable Long id) {
        return this.assignmentService.getAssignmentById(id);
    }

    @PostMapping
    public ResponseEntity<AssignmentDto> createAssignment(@RequestBody CreateAssignmentDto assignementDto) {
        AssignmentDto assignment = this.assignmentService.createAssignment(assignementDto);
        return ResponseEntity.ok(assignment);
    }

    @PutMapping
    public ResponseEntity<AssignmentDto> editAssignemnt(@RequestBody EditAssignmentDto editAssignmentDto) {
        AssignmentDto assignment = this.assignmentService.editAssignment(editAssignmentDto);
        return ResponseEntity.ok(assignment);
    }
}
