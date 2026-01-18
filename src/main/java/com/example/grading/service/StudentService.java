package com.example.grading.service;


import com.example.grading.dto.AddAssignmentDto;
import com.example.grading.dto.CreateStudentDto;
import com.example.grading.dto.StudentDto;
import com.example.grading.persistence.AssignmentEty;
import com.example.grading.persistence.Student;
import com.example.grading.persistence.StudentAssignement;
import com.example.grading.persistence.StudyGroup;
import com.example.grading.persistence.dao.AssignmentRepository;
import com.example.grading.persistence.dao.StudentRepository;
import com.example.grading.persistence.dao.StudyGroupRepository;
import com.example.grading.service.mapper.StudentMapper;
import org.hibernate.sql.ast.tree.update.Assignment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.example.grading.service.mapper.StudentMapper.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final AssignmentRepository assignmentRepository;
    private final StudyGroupRepository studyGroupRepository;

    public StudentService(StudentRepository studentRepository, AssignmentRepository assignmentRepository, StudyGroupRepository studyGroupRepository) {
        this.studentRepository = studentRepository;
        this.assignmentRepository = assignmentRepository;
        this.studyGroupRepository = studyGroupRepository;
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(StudentMapper::mapStudentToDTO).toList();
    }

    public StudentDto getStudentById(Long studentId) {
        return mapStudentDetailsToDTO(Objects.requireNonNull(studentRepository.findById(studentId).orElse(null)));
    }

    public StudentDto saveStudent(CreateStudentDto createStudentDto) {

        StudyGroup studyGroup = studyGroupRepository
                .findById(createStudentDto.getStudyGroup()).orElse(null);
        Student newStudent = mapStudentDtoToModel(createStudentDto);
        if (studyGroup != null) {
            newStudent.setStudyGroup(studyGroup);
        }
        studentRepository.save(newStudent);
        return mapStudentToDTO(newStudent);
    }

    public void addAssignment(AddAssignmentDto assignmentDto) {
        Student student = studentRepository.findById(assignmentDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<AssignmentEty> assignmentsToAdd =
                assignmentRepository.findAllById(assignmentDto.getAssignmentIds());

        for (AssignmentEty a : assignmentsToAdd) {

            boolean alreadyAssigned = student.getAssignmentEties().stream()
                    .anyMatch(sa -> sa.getAssignment().getId().equals(a.getId()));

            if (alreadyAssigned) {
                continue;
            }

            StudentAssignement sa = new StudentAssignement();
            sa.setStudent(student);
            sa.setAssignment(a);

            // default-uri
            sa.setPassed(false);
            sa.setScore(0);
            sa.setGithubRepo("test");

            student.getAssignmentEties().add(sa);
        }

        studentRepository.save(student);
    }

}
