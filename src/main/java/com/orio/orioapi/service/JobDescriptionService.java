package com.orio.orioapi.service;

import com.orio.orioapi.persistence.entity.JobDescription;

import java.util.List;
import java.util.Optional;

public interface JobDescriptionService {

    List<JobDescription> getAllJobDescriptions();

    Optional<JobDescription> getJobDescriptionById(long id);

    JobDescription saveJobDescription(JobDescription jobDescription);

    void deleteJobDescriptionById(long id);

    Iterable<JobDescription> getJobDescriptionsByInterests(List<String> interests);

	Iterable<JobDescription> getJobDescriptionsBySectors(List<String> sectors);
    
    Iterable<JobDescription> getJobDescriptionsBySalary(String salary);

    Iterable<JobDescription> getJobDescriptionsBySchoolSubjects(List<String> schoolSubjects);

    Iterable<JobDescription> getJobDescriptionByJob(List<String> job);

    Iterable<JobDescription> getJobDescriptionByStudyDuration(List<String> studyDuration);

    Iterable<JobDescription> getByCustomFilters(String keywords, String personalityTraitToSearch, String schoolSubjectToSearch, String sectorToSearch, String studyDuration);
}