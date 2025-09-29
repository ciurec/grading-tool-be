package com.example.grading.persistence.dao;

import com.example.grading.persistence.AssignmentEty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<AssignmentEty, Long> {
}
