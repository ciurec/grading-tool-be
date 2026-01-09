package com.example.grading.service;

import com.example.grading.dto.AssignmentDto;
import com.example.grading.dto.CreateAssignmentDto;
import com.example.grading.dto.StudentDto;
import com.example.grading.persistence.AssignmentEty;
import com.example.grading.persistence.dao.AssignmentRepository;
import com.example.grading.service.mapper.AssignmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.example.grading.service.mapper.StudentMapper.mapStudentToDTO;


@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<AssignmentDto> getAllAssignements() {
        return assignmentRepository.findAll().stream().map(AssignmentMapper::mapAssignmentToDto).toList();
    }

    public AssignmentDto getAssignmentById(Long assignmentId) {
        return AssignmentMapper.mapAssignmentToDto(Objects.requireNonNull(assignmentRepository.findById(assignmentId).orElse(null)));
    }
    public AssignmentDto createAssignment(CreateAssignmentDto createAssignmentDto) {

        AssignmentEty assignmentEty = AssignmentMapper.mapAssignmentDtoToModel(createAssignmentDto);
        return AssignmentMapper.mapAssignmentToDto(assignmentRepository.save(assignmentEty));
    }


}
