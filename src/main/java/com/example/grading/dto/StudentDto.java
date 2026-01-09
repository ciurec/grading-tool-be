package com.example.grading.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private Long id;
    private Integer studentNumber;
    private String firstName;
    private String lastName;
    private String email;
    private StudyGroupDto studyGroup;
    private List<StudentAssignmentDto> assignments = new ArrayList<>();
    private int averageScore;
    private boolean passed;
    private String githubRepository;
}
