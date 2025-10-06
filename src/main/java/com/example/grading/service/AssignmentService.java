package com.example.grading.service;

import com.example.grading.dto.AssignmentDto;
import com.example.grading.dto.CreateAssignmentDto;
import com.example.grading.persistence.AssignmentEty;
import com.example.grading.persistence.dao.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<AssignmentDto> getAllAssignements() {
        return assignmentRepository.findAll().stream().map(this::mapAssignmentToDto).toList();
    }

    public AssignmentDto createAssignment(CreateAssignmentDto createAssignmentDto) {

        AssignmentEty assignmentEty = mapAssignmentDtoToModel(createAssignmentDto);
        return mapAssignmentToDto(assignmentRepository.save(assignmentEty));
    }

    private AssignmentDto mapAssignmentToDto(AssignmentEty assignmentEty) {

        AssignmentDto assignmentDto = new AssignmentDto();
        assignmentDto.setTitle(assignmentEty.getTitle());
        if (assignmentEty.getDeadline() != null) {
            assignmentDto.setDeadline(assignmentEty.getDeadline().toString());
        }
        return assignmentDto;
    }

    private AssignmentEty mapAssignmentDtoToModel(CreateAssignmentDto assignementDto) {

        AssignmentEty assignmentEty = new AssignmentEty();
        assignmentEty.setTitle(assignementDto.getAssignementName());
        assignmentEty.setDeadline(LocalDate.parse(assignementDto.getDeadline()));
        return assignmentEty;
    }
}
