package com.orio.orioapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.persistence.repository.JobDescriptionRepository;
import com.orio.orioapi.service.impl.JobDescriptionServiceImpl;
import com.orio.orioapi.util.JobDescriptionTestUtil;
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
        jobDescriptions.add(JobDescriptionTestUtil.createJobDescription(1));
        jobDescriptions.add(JobDescriptionTestUtil.createJobDescription(2));
        when(jobDescriptionRepository.findAll()).thenReturn(jobDescriptions);

        // When
        List<JobDescription> result = jobDescriptionService.getAllJobDescriptions();

        // then
        assertEquals(2,result.size());
        assertEquals(1,result.get(0).getId());
        assertEquals(2,result.get(1).getId());
    }

    @Test
    public void testGetJobDescriptionById() {
        // Given
        JobDescription jobDescription = JobDescriptionTestUtil.createJobDescription(1);
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
        JobDescription jobDescription = JobDescriptionTestUtil.createJobDescription(1);
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

    @Test
    public void getJobDescriptionsByInterests () {
        // Given
        List<String> interests = Arrays.asList("Java", "Programming");

        JobDescriptionRepository jobDescriptionRepository = mock(JobDescriptionRepository.class);
        when(jobDescriptionRepository.findByInterestsIn(interests))
                .thenReturn(Arrays.asList(
                        JobDescriptionTestUtil.createJobDescription1(),
                        JobDescriptionTestUtil.createJobDescription2()
                ));

        // When
        Iterable<JobDescription> result = jobDescriptionService.getJobDescriptionsByInterests(interests);

        // Then
        assertNotNull(result);
    }

    @Test
    public void getJobDescriptionsBySector () {
        // Given
        List<String> sectors = Arrays.asList("Informatique", "Finance");

        JobDescriptionRepository jobDescriptionRepository = mock(JobDescriptionRepository.class);
        when(jobDescriptionRepository.findBySectorsIn(sectors))

                .thenReturn(Arrays.asList(
                        JobDescriptionTestUtil.createJobDescription1(),
                        JobDescriptionTestUtil.createJobDescription2()
                ));


        // When
        Iterable<JobDescription> result = jobDescriptionService.getJobDescriptionsBySectors(sectors);

        // Then
        assertNotNull(result);
    }


    
    @Test
    public void getJobDescriptionsBySalary() {
        // Given
        String salary = "60 000";

        JobDescriptionRepository jobDescriptionRepository = mock(JobDescriptionRepository.class);
        when(jobDescriptionRepository.findBySalaryContainingIgnoreCase(salary))

                .thenReturn(Arrays.asList(
                        JobDescriptionTestUtil.createJobDescription1(),
                        JobDescriptionTestUtil.createJobDescription2()
                ));

        // When
        Iterable<JobDescription> result = jobDescriptionService.getJobDescriptionsBySalary(salary);

        // Then
        assertNotNull(result);
    }

    @Test
    public void getJobDescriptionsBySchoolSubjects () {
        // Given
        List<String> schoolSubjects = Arrays.asList("Informatique", "Beaux-Arts");

        JobDescriptionRepository jobDescriptionRepository = mock(JobDescriptionRepository.class);
        when(jobDescriptionRepository.findByInterestsIn(schoolSubjects))
                .thenReturn(Arrays.asList(
                        JobDescriptionTestUtil.createJobDescription1(),
                        JobDescriptionTestUtil.createJobDescription2()
                ));

        // When
        Iterable<JobDescription> result = jobDescriptionService.getJobDescriptionsBySchoolSubjects(schoolSubjects);

        // Then
        assertNotNull(result);
    }

    @Test
    public void getJobDescriptionsByJob() {
        // Given
        List<String> jobs = Arrays.asList("Actuaire", "Agent de sécurité");

        JobDescriptionRepository jobDescriptionRepository = mock(JobDescriptionRepository.class);
        when(jobDescriptionRepository.findByJobIn(jobs))
                .thenReturn(Arrays.asList(
                        JobDescriptionTestUtil.createJobDescription1(),
                        JobDescriptionTestUtil.createJobDescription2()
                ));

        // When
        Iterable<JobDescription> result = jobDescriptionService.getJobDescriptionsBySchoolSubjects(jobs);

        // Then
        assertNotNull(result);
    }
}

