package com.example.grading.core;

import com.example.grading.dto.AssignmentDto;
import com.example.grading.persistence.dao.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentService {

    private AssignmentRepository repository;

    public AssignmentService(AssignmentRepository repository) {
        this.repository = repository;


    }
    public List<AssignmentDto> getAllAssignements() {
        return new ArrayList<>();
    }
}
