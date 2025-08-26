package com.example.grading.utils;

import com.example.grading.persistence.Assignment;
import com.example.grading.persistence.StudentGroup;
import com.example.grading.persistence.Student;
import com.example.grading.persistence.dao.AssignmentRepository;
import com.example.grading.persistence.dao.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(StudentRepository studentRepository, AssignmentRepository assignmentRepository) {
        return args -> {
            // Creare grupuri
            StudentGroup studentGroup1 = StudentGroup.ONE;
            StudentGroup studentGroup2 = StudentGroup.TWO;

            // Creare assignment-uri
            Assignment assignment1 = new Assignment();
            assignment1.setName("Lab 1");
            Assignment assignment2 = new Assignment();
            assignment2.setName("Lab 2");

            List<Assignment> assignments = new ArrayList<>();
            assignments.add(assignment1);
            assignments.add(assignment2);

            List<Assignment> savedAssignments = assignmentRepository.saveAll(assignments);

            // Creare studenți
            Student student1 = new Student();
            student1.setFirstName("John");
            student1.setLastName("Doe");
            student1.setStudentGroup(studentGroup1);
            student1.setAssignments(savedAssignments);
            student1.setAverageScore(88);
            student1.setPassed(true);
            student1.setGithubRepository("https://github.com/johndoe");

            Student student2 = new Student();
            student2.setFirstName("Jane");
            student2.setLastName("Smith");
            student2.setStudentGroup(studentGroup2);
            student2.setAssignments(savedAssignments);
            student2.setAverageScore(92);
            student2.setPassed(true);
            student2.setGithubRepository("https://github.com/janesmith");

            // Salvare în baza de date
            studentRepository.save(student1);
            studentRepository.save(student2);
        };
    }
}
