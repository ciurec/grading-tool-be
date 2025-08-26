package com.example.grading.persistence.dao;

import com.example.grading.persistence.Similarity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimilarityRepository extends JpaRepository<Similarity, Long> {
}
