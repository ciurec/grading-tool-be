package com.example.grading.service;

import com.example.grading.dto.AssignmentDto;
import com.example.grading.dto.CreateAssignmentDto;
import com.example.grading.dto.EditAssignmentDto;
import com.example.grading.dto.StudentDto;
import com.example.grading.persistence.AssignmentEty;
import com.example.grading.persistence.Student;
import com.example.grading.persistence.StudentAssignement;
import com.example.grading.persistence.dao.AssignmentRepository;
import com.example.grading.persistence.dao.StudentRepository;
import com.example.grading.service.mapper.AssignmentMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.grading.service.mapper.StudentMapper.mapStudentToDTO;


@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, StudentRepository studentRepository) {
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
    }

    public List<AssignmentDto> getAllAssignements() {
        return assignmentRepository.findAll().stream().map(AssignmentMapper::mapAssignmentToDto).toList();
    }

    public AssignmentDto getAssignmentById(Long assignmentId) {
        return AssignmentMapper.mapAssignmentDetailsToDto(Objects.requireNonNull(assignmentRepository.findById(assignmentId).orElse(null)));
    }

    public AssignmentDto createAssignment(CreateAssignmentDto createAssignmentDto) {

        AssignmentEty assignmentEty = AssignmentMapper.mapAssignmentDtoToModel(createAssignmentDto);
        return AssignmentMapper.mapAssignmentToDto(assignmentRepository.save(assignmentEty));
    }

    public AssignmentDto editAssignment(EditAssignmentDto editAssignmentDto) {

        AssignmentEty assignmentEty = assignmentRepository.findById(editAssignmentDto.getAssignmentId()).orElse(null);
        if (assignmentEty != null) {

            assignmentEty.setTitle(editAssignmentDto.getAssignementTitle());
            assignmentEty.setGithubRepo(editAssignmentDto.getRepository());

            assignmentEty.setDeadline(
                    OffsetDateTime.parse(editAssignmentDto.getDeadline(), DateTimeFormatter.ISO_OFFSET_DATE_TIME).toLocalDate());

            // IDs dorite (din request)
            Set<Long> desiredIds = new HashSet<>(editAssignmentDto.getStudentIds());

            // 1) ȘTERGE: tot ce există în DB dar nu e în input
            assignmentEty.getStudents().removeIf(sa ->
                    sa.getStudent() != null && !desiredIds.contains(sa.getStudent().getId())
            );

            // 2) ADAUGĂ: doar cele noi
            Set<Long> existingIds = assignmentEty.getStudents().stream()
                    .map(sa -> sa.getStudent().getId())
                    .collect(Collectors.toSet());

            List<Student> studentsToAdd = this.studentRepository.findAllById(desiredIds);

            for (Student s : studentsToAdd) {
                if (existingIds.contains(s.getId())) continue;

                StudentAssignement sa = new StudentAssignement();
                sa.setStudent(s);
                sa.setAssignment(assignmentEty);

                sa.setPassed(false);
                sa.setGrade(0);
                sa.setGithubRepo("test");
                assignmentEty.getStudents().add(sa);

            }

            assignmentRepository.save(assignmentEty);
            return AssignmentMapper.mapAssignmentToDto(assignmentEty);
        }
        return null;
    }


}
