package com.orio.orioapi.web.dto;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class JobDescriptionDto {

    private String job;
    private Set<String> sectors;
    private Set<String>personalityTraits;
    private Set<String>schoolSubjects;
    private Set<String>interests;
    private String studyDuration;
    private String salary;
    private Set<String>physicalEnvironments;
    private String description;
    private String study;
    private int userScore;
    private int star;

}