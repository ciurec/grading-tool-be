package com.example.grading.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.ast.tree.update.Assignment;

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
    private int score;
    private String githubRepo;

    @OneToMany()
    private List<Similarity> similarities;
}
