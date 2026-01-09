package com.example.grading.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer studentNumber;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne
    private StudyGroup studyGroup;

    @OneToMany(mappedBy = "student")
    private List<StudentAssignement> assignmentEties = new ArrayList<>();
    private int averageScore;
    private boolean passed;

    private String githubRepository;
}
