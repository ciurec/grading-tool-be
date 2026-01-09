package com.example.grading.dto;
import com.example.grading.persistence.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentAssignmentDto {

    private Long assignmentId;
    private Integer assignmentNumber;
    private String title;
    private String deadline;
    private String githubRepo;
    private String studentFirstName;
    private String studentLastName;
    private String studentNumber;

    private boolean passed;
    private int score;

    private List<SimilarityDto> similarities;
}
