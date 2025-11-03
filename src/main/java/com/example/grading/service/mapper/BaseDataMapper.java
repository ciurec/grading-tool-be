package com.example.grading.service.mapper;

import com.example.grading.dto.StudyGroupDto;
import com.example.grading.persistence.StudyGroup;
import org.springframework.stereotype.Service;

@Service
public class BaseDataMapper {

    public static StudyGroupDto mapStudyGroupToDto(StudyGroup studyGroup) {

        StudyGroupDto studyGroupDto = new StudyGroupDto();
        studyGroupDto.setId(studyGroup.getId());
        studyGroupDto.setName(studyGroup.getName());
        return studyGroupDto;
    }
}
