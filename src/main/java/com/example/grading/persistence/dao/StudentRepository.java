package com.example.grading.persistence.dao;


import com.example.grading.persistence.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
