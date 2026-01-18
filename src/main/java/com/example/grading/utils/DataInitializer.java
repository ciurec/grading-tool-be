package com.example.grading.utils;

import com.example.grading.common.AssignmentStatus;
import com.example.grading.common.StudyYear;
import com.example.grading.persistence.*;
import com.example.grading.persistence.dao.AssignmentRepository;
import com.example.grading.persistence.dao.StudentAssignmentRepository;
import com.example.grading.persistence.dao.StudentRepository;
import com.example.grading.persistence.dao.StudyGroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(StudentRepository studentRepository,
                                          AssignmentRepository assignmentRepository,
                                          StudentAssignmentRepository studentAssignmentRepository,
                                          StudyGroupRepository studyGroupRepository) {
        return args -> {

            AssignmentEty assignmentEty1 = new AssignmentEty();
            assignmentEty1.setAssignmentNumber(1);
            assignmentEty1.setGithubRepo("github");
            assignmentEty1.setTitle("Lab 1");
            assignmentEty1.setDeadline(LocalDate.from(LocalDateTime.now()));
            assignmentEty1.setNumberOfStudents(10);
            AssignmentEty assignmentEty2 = new AssignmentEty();
            assignmentEty2.setAssignmentNumber(2);
            assignmentEty2.setGithubRepo("github");
            assignmentEty2.setTitle("Lab 2");
            assignmentEty2.setNumberOfStudents(20);
            assignmentEty2.setDeadline(LocalDate.from(LocalDateTime.now()));
            List<AssignmentEty> assignmentEties = new ArrayList<>();
            assignmentEties.add(assignmentEty1);
            assignmentEties.add(assignmentEty2);

            List<AssignmentEty> savedAssignmentEties = assignmentRepository.saveAll(assignmentEties);

            StudyGroup firstStudyGroup = new StudyGroup();
            firstStudyGroup.setStudyYear(StudyYear.ONE);
            firstStudyGroup.setName("A");
            studyGroupRepository.save(firstStudyGroup);
            StudyGroup secondStudyGroup = new StudyGroup();

            secondStudyGroup.setStudyYear(StudyYear.TWO);
            secondStudyGroup.setName("B");
            studyGroupRepository.save(secondStudyGroup);
            // Creare studenți
            Student student1 = new Student();
            student1.setStudentNumber(1);
            student1.setFirstName("John");
            student1.setLastName("Doe");
            student1.setEmail("mail@mail.com");
            student1.setGithubRepository("https://github.com/");
            student1.setStudyGroup(firstStudyGroup);
            student1.setAverageScore(8);
            student1.setAssignmentStatus(AssignmentStatus.ASSIGNED);
            student1.setGithubRepository("https://github.com/johndoe");

            Student student2 = new Student();
            student2.setStudentNumber(2);
            student2.setFirstName("Jane");
            student2.setLastName("Smith");
            student2.setEmail("mail@mail");
            student2.setStudyGroup(secondStudyGroup);
            student2.setAverageScore(9);
            student2.setGithubRepository("https://github.com/");
            student2.setAssignmentStatus(AssignmentStatus.ASSIGNED);
            student2.setGithubRepository("https://github.com/janesmith");

            studentRepository.save(student1);
            studentRepository.save(student2);

            StudentAssignement studentAssignement1 = new StudentAssignement();
            studentAssignement1.setGithubRepo("Test X");
            studentAssignement1.setScore(10);
            studentAssignement1.setPassed(true);
            studentAssignement1.setAssignment(assignmentEty1);
            studentAssignement1.setStudent(student1);
            studentAssignmentRepository.save(studentAssignement1);

            StudentAssignement studentAssignement2 = new StudentAssignement();
            studentAssignement2.setGithubRepo("Test y");
            studentAssignement2.setScore(4);
            studentAssignement2.setPassed(true);
            studentAssignement2.setAssignment(assignmentEty2);
            studentAssignement2.setStudent(student2);
            studentAssignmentRepository.save(studentAssignement2);
        };
    }
}
