package com.example.grading.controller;

import com.example.grading.dto.StudentDto;
import com.example.grading.dto.StudyGroupDto;
import com.example.grading.service.BaseDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/baseData")
public class BaseDataController {

    private BaseDataService baseDataService;

    public BaseDataController(BaseDataService baseDataService) {
        this.baseDataService = baseDataService;
    }

    @GetMapping("/groups")
    public List<StudyGroupDto> getAllGroups() {

        return this.baseDataService.getAllGroups();
    }
}
