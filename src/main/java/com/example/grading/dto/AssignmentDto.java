package com.example.grading.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AssignmentDto {

    private Long id;
    private Integer assignmentNumber;
    private String title;
    private String deadline;
    private String githubRepo;
    private List<StudentAssignmentDto> students;
    private Integer numberOfStudents;
}
