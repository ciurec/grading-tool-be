package com.example.grading.datamodel;

import com.example.grading.persistence.Similarity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AssignmentDatamodel {


    private String name;
    private boolean passed;
    private int score;

    private List<SimilarityDatamodel> similarities;
}
