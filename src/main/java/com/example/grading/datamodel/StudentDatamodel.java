package com.example.grading.datamodel;

import com.example.grading.persistence.Assignment;
import com.example.grading.persistence.StudentGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StudentDatamodel {

    private String firstName;
    private String lastName;
    private StudentGroup studentGroup;
    private List<AssignmentDatamodel> assignments = new ArrayList<>();
    private int averageScore;
    private boolean passed;
    private String githubRepository;
}
