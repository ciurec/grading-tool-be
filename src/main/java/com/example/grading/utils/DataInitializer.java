package com.example.grading.utils;

import com.example.grading.persistence.AssignmentEty;
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
            AssignmentEty assignmentEty1 = new AssignmentEty();
            assignmentEty1.setTitle("Lab 1");
            AssignmentEty assignmentEty2 = new AssignmentEty();
            assignmentEty2.setTitle("Lab 2");

            List<AssignmentEty> assignmentEties = new ArrayList<>();
            assignmentEties.add(assignmentEty1);
            assignmentEties.add(assignmentEty2);

            List<AssignmentEty> savedAssignmentEties = assignmentRepository.saveAll(assignmentEties);

            // Creare studenți
            Student student1 = new Student();
            student1.setFirstName("John");
            student1.setLastName("Doe");
            student1.setStudentGroup(studentGroup1);
            student1.setAssignmentEties(savedAssignmentEties);
            student1.setAverageScore(88);
            student1.setPassed(true);
            student1.setGithubRepository("https://github.com/johndoe");

            Student student2 = new Student();
            student2.setFirstName("Jane");
            student2.setLastName("Smith");
            student2.setStudentGroup(studentGroup2);
            student2.setAssignmentEties(savedAssignmentEties);
            student2.setAverageScore(92);
            student2.setPassed(true);
            student2.setGithubRepository("https://github.com/janesmith");

            // Salvare în baza de date
            studentRepository.save(student1);
            studentRepository.save(student2);
        };
    }
}
