package com.example.grading.persistence.dao;

import com.example.grading.persistence.StudentAssignement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentAssignmentRepository extends JpaRepository<StudentAssignement, Long> {

    Optional<StudentAssignement> findByStudentIdAndAssignmentId(Long studentId, Long assignmentId);
}
