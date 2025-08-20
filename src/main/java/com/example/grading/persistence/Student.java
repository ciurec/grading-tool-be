package com.example.grading.persistence;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String name;
    private Group group;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Assignment> assignments = new ArrayList<>();

    private int averageScore;
    private boolean passed;
    private String githubRepository;
}
