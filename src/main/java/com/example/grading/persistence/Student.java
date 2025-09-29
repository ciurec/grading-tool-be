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

    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private StudentGroup studentGroup;

    @ManyToMany
    @JoinTable(
            name = "student_assignment",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "assignment_id")
    )
    private List<AssignmentEty> assignmentEties = new ArrayList<>();
    private int averageScore;
    private boolean passed;

    private String githubRepository;
}
