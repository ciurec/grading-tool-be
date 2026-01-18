package com.example.grading.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AddAssignmentDto {

    private Long studentId;
    private List<Long> assignmentIds = new ArrayList<>();
}
