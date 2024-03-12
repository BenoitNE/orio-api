package com.orio.orioapi.web.mapper.impl;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.web.dto.JobDescriptionDto;
import com.orio.orioapi.web.mapper.JobDescriptionMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobDescriptionMapperImpl implements JobDescriptionMapper {
    @Override
    public JobDescriptionDto entityToDto(JobDescription jobDescription) {
        JobDescriptionDto jobDescriptionDto = new JobDescriptionDto();
        jobDescriptionDto.setJob(jobDescription.getJob());
        jobDescriptionDto.setSectors(jobDescription.getSectors());
        jobDescriptionDto.setPersonalityTraits(jobDescription.getPersonalityTraits());
        jobDescriptionDto.setSchoolSubjects(jobDescription.getSchoolSubjects());
        jobDescriptionDto.setInterests(jobDescription.getInterests());
        jobDescriptionDto.setStudyDuration(jobDescription.getStudyDuration());
        jobDescriptionDto.setSalary(jobDescription.getSalary());
        jobDescriptionDto.setPhysicalEnvironments(jobDescription.getPhysicalEnvironments());
        jobDescriptionDto.setDescription(jobDescription.getDescription());
        jobDescriptionDto.setStudy(jobDescription.getStudy());
        jobDescriptionDto.setUserScore(jobDescription.getUserScore());
        jobDescriptionDto.setStar(jobDescription.getStar());
        return jobDescriptionDto;
    }

    @Override
    public List<JobDescriptionDto> entitiesToDtoList(List<JobDescription> jobDescriptions) {
        List<JobDescriptionDto> jobDescriptionDtoList = new ArrayList<>();
        for(JobDescription jobDescription: jobDescriptions){
            jobDescriptionDtoList.add(entityToDto(jobDescription));
        }
        return jobDescriptionDtoList;
    }
}
