package com.example.grading.dto;

import com.example.grading.persistence.StudentGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CreateStudentDto {

    private String firstName;
    private String lastName;
    private StudentGroup studentGroup;
    private String githubRepository;
}
