package com.orio.orioapi.web.controller;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.service.JobDescriptionService;
import com.orio.orioapi.web.dto.JobDescriptionDto;
import com.orio.orioapi.web.mapper.JobDescriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job-descriptions")
@CrossOrigin("*")
public class JobDescriptionUserController {

    private final JobDescriptionService jobDescriptionService;

    private final JobDescriptionMapper jobDescriptionMapper;

    @Autowired
    public JobDescriptionUserController(JobDescriptionService jobDescriptionService, JobDescriptionMapper jobDescriptionMapper) {
        this.jobDescriptionService = jobDescriptionService;
        this.jobDescriptionMapper = jobDescriptionMapper;
    }

    @GetMapping
    public ResponseEntity<List<JobDescriptionDto>> getAllJobDescriptions() {
        List<JobDescriptionDto> jobDescriptions = jobDescriptionMapper.entitiesToDtoList(jobDescriptionService.getAllJobDescriptions());
        return ResponseEntity.ok(jobDescriptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDescriptionDto> getJobDescriptionById(@PathVariable long id) {
        Optional<JobDescription> jobDescription = jobDescriptionService.getJobDescriptionById(id);
        if (jobDescription != null) {
            JobDescriptionDto jobDescriptionDto = jobDescriptionMapper.entityToDto(jobDescription.get());
            return ResponseEntity.ok(jobDescriptionDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/interests")
    public ResponseEntity<List<JobDescriptionDto>> getJobDescriptionByInterests(@RequestParam("interests") List<String> interests) {
        Iterable<JobDescription> jobDescriptions = jobDescriptionService.getJobDescriptionsByInterests(interests);
        if (jobDescriptions != null) {
            List<JobDescriptionDto> jobDescriptionDtoList = jobDescriptionMapper.entitiesToDtoList(iterableToList(jobDescriptions));
            return ResponseEntity.ok(jobDescriptionDtoList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/salary")
    public ResponseEntity<List<JobDescriptionDto>> getJobDescriptionBySalary(@RequestParam("salary") String salary) {
        Iterable<JobDescription> jobDescriptions = jobDescriptionService.getJobDescriptionsBySalary(salary);
        if (jobDescriptions != null) {
            List<JobDescriptionDto> jobDescriptionDtoList = jobDescriptionMapper.entitiesToDtoList(iterableToList(jobDescriptions));
            return ResponseEntity.ok(jobDescriptionDtoList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/school-subjects")
    public ResponseEntity<List<JobDescriptionDto>> getJobDescriptionBySchoolSubjects(@RequestParam("schoolSubjects") List<String> schoolSubjects) {
        Iterable<JobDescription> jobDescriptions = jobDescriptionService.getJobDescriptionsBySchoolSubjects(schoolSubjects);
        if (jobDescriptions != null) {
            List<JobDescriptionDto> jobDescriptionDtoList = jobDescriptionMapper.entitiesToDtoList(iterableToList(jobDescriptions));
            return ResponseEntity.ok(jobDescriptionDtoList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private static <T> List<T> iterableToList(Iterable<T> iterable) {
        List<T> resultList = new ArrayList<>();

        for (T element : iterable) {
            resultList.add(element);
        }

        return resultList;
    }
}

