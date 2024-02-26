package com.orio.orioapi.web.dto;
import lombok.Data;

import java.util.List;

@Data
public class JobDescriptionDto {

    private String job;
    private List<String> sectors;
    private List<String> personalityTraits;
    private List<String> schoolSubjects;
    private List<String> interests;
    private String studyDuration;
    private String salary;
    private String socialEnvironment;
    private List<String> physicalEnvironments;
    private String description;
    private String study;


}

