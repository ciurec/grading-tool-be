package com.example.grading.core;

import com.example.grading.datamodel.AssignmentDatamodel;
import com.example.grading.datamodel.SimilarityDatamodel;
import com.example.grading.persistence.dao.SimilarityRepository;

import java.util.ArrayList;
import java.util.List;

public class SimilarityService {

    private SimilarityRepository similarityRepository;

    public SimilarityService(SimilarityRepository similarityRepository) {
        this.similarityRepository = similarityRepository;
    }

    public List<SimilarityDatamodel> getAllSimilaritiesByAssignment(Long assignmentId) {
        return new ArrayList<>();
    }
}
