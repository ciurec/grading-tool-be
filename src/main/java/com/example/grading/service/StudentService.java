package com.example.grading.service;


import com.example.grading.dto.SyncAssignmentDto;
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
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Transactional
    public void syncAssignment(SyncAssignmentDto assignmentDto) {

        Student student = studentRepository.findById(assignmentDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // IDs dorite (din request)
        Set<Long> desiredIds = new HashSet<>(assignmentDto.getAssignmentIds());

        // 1) ȘTERGE: tot ce există în DB dar nu e în input
        student.getAssignmentEties().removeIf(sa ->
                sa.getAssignment() != null && !desiredIds.contains(sa.getAssignment().getId())
        );

        // 2) ADAUGĂ: doar cele noi
        Set<Long> existingIds = student.getAssignmentEties().stream()
                .map(sa -> sa.getAssignment().getId())
                .collect(Collectors.toSet());

        List<AssignmentEty> assignmentsToAdd = assignmentRepository.findAllById(desiredIds);

        for (AssignmentEty a : assignmentsToAdd) {
            if (existingIds.contains(a.getId())) continue;

            StudentAssignement sa = new StudentAssignement();
            sa.setStudent(student);
            sa.setAssignment(a);

            sa.setPassed(false);
            sa.setScore(0);
            sa.setGithubRepo("test");

            student.getAssignmentEties().add(sa);
        }

        studentRepository.save(student);
    }

    @Transactional
    public void unassignAssignments(SyncAssignmentDto dto) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Set<Long> idsToUnassign = new HashSet<>(dto.getAssignmentIds());

        List<StudentAssignement> toRemove = student.getAssignmentEties().stream()
                .filter(sa -> sa.getAssignment() != null && idsToUnassign.contains(sa.getAssignment().getId()))
                .toList();

        toRemove.forEach(student::removeAssignmentLink);
    }


}
