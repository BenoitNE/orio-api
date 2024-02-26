package com.orio.orioapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.persistence.repository.JobDescriptionRepository;
import com.orio.orioapi.service.impl.JobDescriptionServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class JobDescriptionServiceTest {

    @Mock
    private JobDescriptionRepository jobDescriptionRepository;

    @InjectMocks
    private JobDescriptionServiceImpl jobDescriptionService;

    @Test
    public void testGetAllJobDescriptions() {
        // Given
        List<JobDescription> jobDescriptions = new ArrayList<>();
        jobDescriptions.add(createJobDescription(1));
        jobDescriptions.add(createJobDescription(2));
        when(jobDescriptionRepository.findAll()).thenReturn(jobDescriptions);

        // When
        List<JobDescription> result = jobDescriptionService.getAllJobDescriptions();

        // then
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(1).getId());
    }

    @Test
    public void testGetJobDescriptionById() {
        // Given
        JobDescription jobDescription = createJobDescription(1);
        when(jobDescriptionRepository.findById(1L)).thenReturn(Optional.of(jobDescription));

        // When
        Optional<JobDescription> result = jobDescriptionService.getJobDescriptionById(1);

        // Then
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals("TestJob", result.get().getJob());
    }

    @Test
    public void testSaveJobDescription() {
        // Given
        JobDescription jobDescription = createJobDescription(1);
        when(jobDescriptionRepository.save(jobDescription)).thenReturn(jobDescription);

        // When
        JobDescription result = jobDescriptionService.saveJobDescription(jobDescription);

        // Then
        assertEquals(1, result.getId());
        assertEquals("TestJob", result.getJob());
    }

    @Test
    public void testDeleteJobDescriptionById() {
        // Given
        long userId = 1;

        // When
        jobDescriptionService.deleteJobDescriptionById(userId);

        // Then
        verify(jobDescriptionRepository, times(1)).deleteById(userId);
    }

    private JobDescription createJobDescription(long id) {
        JobDescription jobDescription = new JobDescription();
        jobDescription.setId(id);
        jobDescription.setJob("TestJob");
        return jobDescription;
    }
}

