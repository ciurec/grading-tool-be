package com.example.grading.service;

import com.example.grading.dto.SimilarityDto;
import com.example.grading.persistence.dao.SimilarityRepository;

import java.util.ArrayList;
import java.util.List;

public class SimilarityService {

    private SimilarityRepository similarityRepository;

    public SimilarityService(SimilarityRepository similarityRepository) {
        this.similarityRepository = similarityRepository;
    }

    public List<SimilarityDto> getAllSimilaritiesByAssignment(Long assignmentId) {
        return new ArrayList<>();
    }
}
