package com.example.grading.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Similarity {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private double similarityScore;

}
