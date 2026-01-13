package com.example.grading.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentAssignmentDto {

    private Integer assignmentNumber;
    private String studentNumber;
    private String title;
    private String deadline;
    private String githubRepo;
    private String studentFirstName;
    private String studentLastName;

    private boolean passed;
    private int score;

    private List<SimilarityDto> similarities;
}
