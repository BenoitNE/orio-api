package com.orio.orioapi.web.controller;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.service.JobDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job-descriptions")
@CrossOrigin("*")
public class JobDescriptionController {

    private final JobDescriptionService jobDescriptionService;

    @Autowired
    public JobDescriptionController(JobDescriptionService jobDescriptionService) {
        this.jobDescriptionService = jobDescriptionService;
    }

    @GetMapping
    public List<JobDescription> getAllJobDescriptions() {
        return jobDescriptionService.getAllJobDescriptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDescription> getJobDescriptionById(@PathVariable long id) {
        Optional<JobDescription> jobDescription = jobDescriptionService.getJobDescriptionById(id);
        return jobDescription.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JobDescription> createJobDescription(@RequestBody JobDescription jobDescription) {
        JobDescription savedJobDescription = jobDescriptionService.saveJobDescription(jobDescription);
        return ResponseEntity.ok(savedJobDescription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobDescription> updateJobDescription(@PathVariable long id, @RequestBody JobDescription jobDescription) {
        if (jobDescriptionService.getJobDescriptionById(id).isPresent()) {
            jobDescription.setId(id);
            JobDescription updatedUser = jobDescriptionService.saveJobDescription(jobDescription);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobDescription(@PathVariable long id) {
        jobDescriptionService.deleteJobDescriptionById(id);
        return ResponseEntity.noContent().build();
    }
}

