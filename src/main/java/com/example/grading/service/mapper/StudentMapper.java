package com.example.grading.service.mapper;

import com.example.grading.dto.StudentAssignmentDto;
import com.example.grading.dto.CreateStudentDto;
import com.example.grading.dto.StudentDto;
import com.example.grading.persistence.Student;

import java.util.List;

public class StudentMapper {

    public static StudentDto mapStudentToDTO(Student student) {

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setStudentNumber(student.getStudentNumber());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setGithubRepository(student.getGithubRepository());
        studentDto.setAverageScore(student.getAverageScore());

        List<StudentAssignmentDto> studentAssignmentDtos = student.getAssignmentEties().stream().map(AssignmentMapper::mapStudentAssignmentToDto).toList();
        studentDto.setAssignments(studentAssignmentDtos);

        studentDto.setStudyGroup(BaseDataMapper.mapStudyGroupToDto(student.getStudyGroup()));
        studentDto.setPassed(student.isPassed());
        return studentDto;
    }

    public static Student mapStudentDtoToModel(CreateStudentDto studentDto) {

        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setGithubRepository(studentDto.getGithubRepository());
        return student;
    }
}
