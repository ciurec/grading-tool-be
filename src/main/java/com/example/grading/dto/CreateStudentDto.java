package com.example.grading.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateStudentDto {

    private String firstName;
    private String lastName;
    private Long studyGroup;
    private String githubRepository;
}
