package com.example.grading.dto;
import com.example.grading.common.AssignmentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentAssignmentDto {

    private Long assignmentId;
    private Long studentId;
    private Integer assignmentNumber;
    private String studentNumber;
    private String title;
    private String deadline;
    private String githubRepo;
    private String studentFirstName;
    private String studentLastName;

    private AssignmentStatus assignmentStatus;
    private int grade;

    private List<SimilarityDto> similarities;
}
