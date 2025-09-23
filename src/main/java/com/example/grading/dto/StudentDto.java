package com.example.grading.dto;

import com.example.grading.persistence.StudentGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private String firstName;
    private String lastName;
    private StudentGroup studentGroup;
    private List<AssignmentDto> assignments = new ArrayList<>();
    private int averageScore;
    private boolean passed;
    private String githubRepository;
}
