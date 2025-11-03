package com.example.grading.service;


import com.example.grading.dto.CreateStudentDto;
import com.example.grading.dto.StudentDto;
import com.example.grading.persistence.Student;
import com.example.grading.persistence.StudyGroup;
import com.example.grading.persistence.dao.StudentRepository;
import com.example.grading.persistence.dao.StudyGroupRepository;
import com.example.grading.service.mapper.BaseDataMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private StudyGroupRepository studyGroupRepository;

    public StudentService(StudentRepository studentRepository, StudyGroupRepository studyGroupRepository) {
        this.studentRepository = studentRepository;
        this.studyGroupRepository = studyGroupRepository;
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(this::mapStudentToDatamodel).toList();
    }

    public StudentDto createStudent(CreateStudentDto createStudentDto) {

        StudyGroup studyGroup = studyGroupRepository
                .findById(createStudentDto.getStudyGroup()).orElse(null);
        Student newStudent = mapStudentDtoToModel(createStudentDto);
        if (studyGroup != null) {
            newStudent.setStudyGroup(studyGroup);
        }
        studentRepository.save(newStudent);
        return mapStudentToDatamodel(newStudent);
    }

    private StudentDto mapStudentToDatamodel(Student student) {

        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setGithubRepository(student.getGithubRepository());
        studentDto.setAverageScore(student.getAverageScore());
        studentDto.setStudyGroup(BaseDataMapper.mapStudyGroupToDto(student.getStudyGroup()));
        studentDto.setPassed(student.isPassed());
        return studentDto;
    }

    private Student mapStudentDtoToModel(CreateStudentDto studentDto) {

        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setGithubRepository(studentDto.getGithubRepository());
        return student;
    }
}
