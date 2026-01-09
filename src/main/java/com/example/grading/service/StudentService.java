package com.example.grading.service;


import com.example.grading.dto.CreateStudentDto;
import com.example.grading.dto.StudentDto;
import com.example.grading.persistence.Student;
import com.example.grading.persistence.StudyGroup;
import com.example.grading.persistence.dao.StudentRepository;
import com.example.grading.persistence.dao.StudyGroupRepository;
import com.example.grading.service.mapper.AssignmentMapper;
import com.example.grading.service.mapper.BaseDataMapper;
import com.example.grading.service.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.example.grading.service.mapper.StudentMapper.mapStudentDtoToModel;
import static com.example.grading.service.mapper.StudentMapper.mapStudentToDTO;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudyGroupRepository studyGroupRepository;

    public StudentService(StudentRepository studentRepository, StudyGroupRepository studyGroupRepository) {
        this.studentRepository = studentRepository;
        this.studyGroupRepository = studyGroupRepository;
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(StudentMapper::mapStudentToDTO).toList();
    }

    public StudentDto getStudentById(Long studentId) {
        return mapStudentToDTO(Objects.requireNonNull(studentRepository.findById(studentId).orElse(null)));
    }

    public StudentDto createStudent(CreateStudentDto createStudentDto) {

        StudyGroup studyGroup = studyGroupRepository
                .findById(createStudentDto.getStudyGroup()).orElse(null);
        Student newStudent = mapStudentDtoToModel(createStudentDto);
        if (studyGroup != null) {
            newStudent.setStudyGroup(studyGroup);
        }
        studentRepository.save(newStudent);
        return mapStudentToDTO(newStudent);
    }

}
