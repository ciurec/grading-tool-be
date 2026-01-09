package com.example.grading.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class AssignmentEty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer assignmentNumber;

    private String title;
    private LocalDate deadline;
    private String githubRepo;
    private Integer numberOfStudents;
    @OneToMany(mappedBy = "assignment")
    private List<StudentAssignement> students;
}
