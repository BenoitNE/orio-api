package com.orio.orioapi.web.mapper;


import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.web.dto.JobDescriptionDto;

import java.util.List;

public interface JobDescriptionMapper {
    JobDescriptionDto entityToDto (JobDescription jobDescription);
    List<JobDescriptionDto> entitiesToDtoList (List<JobDescription> jobDescriptions);
}

