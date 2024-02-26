package com.orio.orioapi.controller;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.service.JobDescriptionService;
import com.orio.orioapi.web.controller.JobDescriptionController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class JobDescriptionControllerTest {

    @Mock
    private JobDescriptionService jobDescriptionService;

    @InjectMocks
    private JobDescriptionController jobDescriptionController;

    @Test
    void testGetAllJobDescriptions() {
        // Given
        List<JobDescription> jobDescriptions = Arrays.asList(new JobDescription(), new JobDescription());
        when(jobDescriptionService.getAllJobDescriptions()).thenReturn(jobDescriptions);

        // When
        List<JobDescription> result = jobDescriptionController.getAllJobDescriptions();

        // Then
        assertEquals(2, result.size());
    }

    @Test
    void testGetJobDescriptionById() {
        // Given
        JobDescription jobDescription = new JobDescription();
        when(jobDescriptionService.getJobDescriptionById(1L)).thenReturn(Optional.of(jobDescription));

        // When
        ResponseEntity<JobDescription> result = jobDescriptionController.getJobDescriptionById(1L);

        // Then
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(jobDescription, result.getBody());
    }

    @Test
    void testGetJobDescriptionByIdNotFound() {
        // Given
        when(jobDescriptionService.getJobDescriptionById(1L)).thenReturn(Optional.empty());

        // When
        ResponseEntity<JobDescription> result = jobDescriptionController.getJobDescriptionById(1L);

        // Then
        assertEquals(404, result.getStatusCodeValue());
        assertNull(result.getBody());
    }

    @Test
    void testCreateJobDescription() {
        // Given
        JobDescription jobDescription = new JobDescription();
        when(jobDescriptionService.saveJobDescription(any())).thenReturn(jobDescription);

        // When
        ResponseEntity<JobDescription> result = jobDescriptionController.createJobDescription(jobDescription);

        // Then
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(jobDescription, result.getBody());
    }

    @Test
    void testUpdateJobDescription() {
        // Given
        JobDescription existingJobDescription = new JobDescription();
        existingJobDescription.setId(1L);
        when(jobDescriptionService.getJobDescriptionById(1L)).thenReturn(Optional.of(existingJobDescription));
        when(jobDescriptionService.saveJobDescription(any())).thenReturn(existingJobDescription);

        // When
        ResponseEntity<JobDescription> result = jobDescriptionController.updateJobDescription(1L, existingJobDescription);

        // Then
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(existingJobDescription, result.getBody());
    }

    @Test
    void testUpdateJobDescriptionNotFound() {
        // Given
        when(jobDescriptionService.getJobDescriptionById(1L)).thenReturn(Optional.empty());

        // When
        ResponseEntity<JobDescription> result = jobDescriptionController.updateJobDescription(1L, new JobDescription());

        // Then
        assertEquals(404, result.getStatusCodeValue());
        assertNull(result.getBody());
    }

    @Test
    void testDeleteJobDescription() {
        // Given
        ResponseEntity<Void> result = jobDescriptionController.deleteJobDescription(1L);

        // When
        assertEquals(204, result.getStatusCodeValue());

        // Then
        verify(jobDescriptionService, times(1)).deleteJobDescriptionById(1L);
    }
}
