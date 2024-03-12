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
}