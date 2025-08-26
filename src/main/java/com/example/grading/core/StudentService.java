package com.example.grading.core;


import com.example.grading.datamodel.StudentDatamodel;
import com.example.grading.persistence.Student;
import com.example.grading.persistence.dao.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDatamodel> getAllStudents() {
        return studentRepository.findAll().stream().map(this::mapStudentToDatamodel).toList();
    }

    private StudentDatamodel mapStudentToDatamodel(Student student) {

        StudentDatamodel studentDatamodel = new StudentDatamodel();
        studentDatamodel.setFirstName(student.getFirstName());
        studentDatamodel.setLastName(student.getLastName());
        return studentDatamodel;
    }
}
