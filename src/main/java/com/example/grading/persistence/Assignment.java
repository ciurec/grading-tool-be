package com.example.grading.persistence;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean passed;
    private int score;

    @OneToMany
    private List<Similarity> similarities;
}
