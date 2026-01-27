package com.example.grading.service.mapper;

import com.example.grading.dto.StudentAssignmentDto;
import com.example.grading.dto.AssignmentDto;
import com.example.grading.dto.CreateAssignmentDto;
import com.example.grading.persistence.AssignmentEty;
import com.example.grading.persistence.StudentAssignement;

import java.time.LocalDate;
import java.util.List;

public class AssignmentMapper {

    public static AssignmentDto mapAssignmentToDto(AssignmentEty assignmentEty) {

        AssignmentDto assignmentDto = new AssignmentDto();
        assignmentDto.setId(assignmentEty.getId());
        assignmentDto.setAssignmentNumber(assignmentEty.getAssignmentNumber());
        assignmentDto.setTitle(assignmentEty.getTitle());
        if (assignmentEty.getDeadline() != null) {
            assignmentDto.setDeadline(assignmentEty.getDeadline().toString());
        }
        assignmentDto.setGithubRepo(assignmentEty.getGithubRepo());
        assignmentDto.setNumberOfStudents(assignmentEty.getNumberOfStudents());
        return assignmentDto;
    }

    public static AssignmentDto mapAssignmentDetailsToDto(AssignmentEty assignmentEty) {

        AssignmentDto assignmentDto = new AssignmentDto();
        assignmentDto.setId(assignmentEty.getId());
        assignmentDto.setAssignmentNumber(assignmentEty.getAssignmentNumber());
        assignmentDto.setTitle(assignmentEty.getTitle());
        List<StudentAssignmentDto> studentAssignmentDtos = assignmentEty.getStudents().stream().map(AssignmentMapper::mapStudentAssignmentToDto).toList();
        assignmentDto.setStudents(studentAssignmentDtos);
        if (assignmentEty.getDeadline() != null) {
            assignmentDto.setDeadline(assignmentEty.getDeadline().toString());
        }
        assignmentDto.setGithubRepo(assignmentEty.getGithubRepo());
        assignmentDto.setNumberOfStudents(assignmentEty.getNumberOfStudents());
        return assignmentDto;
    }

    public static AssignmentEty mapAssignmentDtoToModel(CreateAssignmentDto assignementDto) {

        AssignmentEty assignmentEty = new AssignmentEty();
        assignmentEty.setAssignmentNumber(assignementDto.getAssignmentNumber());
        assignmentEty.setTitle(assignementDto.getTitle());
        assignmentEty.setDeadline(LocalDate.parse(assignementDto.getDeadline()));
        assignmentEty.setGithubRepo(assignmentEty.getGithubRepo());
        assignmentEty.setNumberOfStudents(assignmentEty.getNumberOfStudents());
        return assignmentEty;
    }

    public static StudentAssignmentDto mapStudentAssignmentToDto(StudentAssignement studentAssignement) {

        StudentAssignmentDto studentAssignmentDto = new StudentAssignmentDto();
        studentAssignmentDto.setGrade(studentAssignement.getGrade());
        studentAssignmentDto.setAssignmentId(studentAssignement.getAssignment().getId());
        studentAssignmentDto.setStudentId(studentAssignement.getStudent().getId());
        studentAssignmentDto.setStudentFirstName(studentAssignement.getStudent().getFirstName());
        studentAssignmentDto.setStudentLastName(studentAssignement.getStudent().getFirstName());
        studentAssignmentDto.setGithubRepo(studentAssignement.getGithubRepo());
        studentAssignmentDto.setDeadline(studentAssignement.getAssignment().getDeadline().toString());
        studentAssignmentDto.setAssignmentStatus(studentAssignement.getStatus());
        studentAssignmentDto.setTitle(studentAssignement.getAssignment().getTitle());
        studentAssignmentDto.setAssignmentNumber(studentAssignement.getAssignment().getAssignmentNumber());

        return studentAssignmentDto;
    }

}
