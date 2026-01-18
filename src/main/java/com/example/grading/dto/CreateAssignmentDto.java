package com.example.grading.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateAssignmentDto {

    private Integer assignmentNumber;
    private String title;
    private String deadline;
    private String githubRepo;
    private Integer numberOfStudents;
}
