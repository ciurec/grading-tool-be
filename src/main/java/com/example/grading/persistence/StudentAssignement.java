package com.example.grading.persistence;

import com.example.grading.common.AssignmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(
        name = "student_assignment",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"student_id", "assignment_id"}
        )
)
public class StudentAssignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;
    @ManyToOne
    private AssignmentEty assignment;

    private boolean passed;
    private int grade;
    private String githubRepo;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;

    @OneToMany()
    private List<Similarity> similarities;
}
