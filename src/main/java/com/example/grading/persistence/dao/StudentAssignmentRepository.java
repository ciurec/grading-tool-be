package com.example.grading.persistence.dao;

import com.example.grading.persistence.StudentAssignement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAssignmentRepository extends JpaRepository<StudentAssignement, Long> {
}
