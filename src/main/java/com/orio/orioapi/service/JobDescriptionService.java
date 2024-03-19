package com.orio.orioapi.service;

import com.orio.orioapi.persistence.entity.JobDescription;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.List;
import java.util.Optional;

public interface JobDescriptionService {

    List<JobDescription> getAllJobDescriptions();

    Optional<JobDescription> getJobDescriptionById(long id);

    JobDescription saveJobDescription(JobDescription jobDescription);

    void deleteJobDescriptionById(long id);

    Iterable<JobDescription> getJobDescriptionsByInterests(List<String> interests);
<<<<<<< HEAD





	

	Iterable<JobDescription> getJobDescriptionsBySectors(List<String> sectors);

=======
    
    Iterable<JobDescription> getJobDescriptionsBySalary(String salary);

    Iterable<JobDescription> getJobDescriptionsBySchoolSubjects(List<String> schoolSubjects);

    Iterable<JobDescription> getJobDescriptionByJob(List<String> job);
>>>>>>> af15f3847ba447f46212416677d9304c73a353b3
}