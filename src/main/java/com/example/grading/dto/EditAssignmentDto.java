package com.example.grading.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class EditAssignmentDto {

    private Long assignmentId;
    private String assignementTitle;
    private String deadline;
    private String repository;
    private List<Long> studentIds;
}
