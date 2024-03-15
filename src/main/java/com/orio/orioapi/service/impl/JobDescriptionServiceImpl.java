package com.orio.orioapi.service.impl;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.persistence.repository.JobDescriptionRepository;
import com.orio.orioapi.service.JobDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobDescriptionServiceImpl implements JobDescriptionService {

    private final JobDescriptionRepository jobDescriptionRepository;

    @Autowired
    public JobDescriptionServiceImpl(JobDescriptionRepository jobDescriptionRepository) {
        this.jobDescriptionRepository = jobDescriptionRepository;
    }
    @Override
    public List<JobDescription> getAllJobDescriptions() {
        return jobDescriptionRepository.findAll();
    }
    @Override
    public Optional<JobDescription> getJobDescriptionById(long id) {
        return jobDescriptionRepository.findById(id);
    }
    @Override
    public JobDescription saveJobDescription(JobDescription jobDescription) {
        return jobDescriptionRepository.save(jobDescription);
    }
    @Override
    public void deleteJobDescriptionById(long id) {
        jobDescriptionRepository.deleteById(id);
    }

    @Override
    public Iterable<JobDescription> getJobDescriptionsByInterests(List<String> interests) {
        return jobDescriptionRepository.findByInterestsIn(interests);
    }
    
    @Override
    public Iterable<JobDescription> getJobDescriptionsBySalary(String salary) {
        return jobDescriptionRepository.findBySalaryContainingIgnoreCase(salary);
    }
}
