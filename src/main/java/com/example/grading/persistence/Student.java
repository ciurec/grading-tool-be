package com.example.grading.persistence;

import com.example.grading.common.AssignmentStatus;
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

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentAssignement> assignmentEties = new ArrayList<>();
    private int averageScore;
    @Enumerated(EnumType.STRING)
    private AssignmentStatus assignmentStatus = AssignmentStatus.NEW;
    private String githubRepository;

    public void removeAssignmentLink(StudentAssignement sa) {
        assignmentEties.remove(sa);
        sa.setStudent(null);
        sa.setAssignment(null);
    }
}
