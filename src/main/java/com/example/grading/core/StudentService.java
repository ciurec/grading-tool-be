package com.example.grading.core;


import com.example.grading.dto.CreateStudentDto;
import com.example.grading.dto.StudentDto;
import com.example.grading.persistence.Student;
import com.example.grading.persistence.dao.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(this::mapStudentToDatamodel).toList();
    }

    public StudentDto createStudent(CreateStudentDto createStudentDto) {

        Student student = mapStudentDtoToModel(createStudentDto);
        return mapStudentToDatamodel(studentRepository.save(student));
    }

    private StudentDto mapStudentToDatamodel(Student student) {

        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        return studentDto;
    }

    private Student mapStudentDtoToModel(CreateStudentDto studentDto) {

        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setGithubRepository(studentDto.getGithubRepository());
        student.setStudentGroup(studentDto.getStudentGroup());
        return student;
    }
}
