package com.example.grading.service;

import com.example.grading.dto.StudyGroupDto;
import com.example.grading.persistence.StudyGroup;
import com.example.grading.persistence.dao.StudyGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDataService {

    private StudyGroupRepository studyGroupRepository;

    public BaseDataService(StudyGroupRepository studyGroupRepository) {
        this.studyGroupRepository = studyGroupRepository;
    }

    public List<StudyGroupDto> getAllGroups() {
        return this.studyGroupRepository.findAll().stream().map(this::mapStudyGroupToDto).toList();
    }

    private StudyGroupDto mapStudyGroupToDto(StudyGroup studyGroup) {

        StudyGroupDto studyGroupDto = new StudyGroupDto();
        studyGroupDto.setName(studyGroup.getName());
        return studyGroupDto;
    }
}
