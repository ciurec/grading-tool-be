package com.example.grading.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AssignmentDto {


    private String title;
    private boolean passed;
    private String deadline;
    private int score;

    private List<SimilarityDto> similarities;
}
