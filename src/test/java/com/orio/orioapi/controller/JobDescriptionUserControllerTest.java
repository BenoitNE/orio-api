package com.orio.orioapi.controller;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.service.JobDescriptionService;
import com.orio.orioapi.util.JobDescriptionDtoTestUtil;
import com.orio.orioapi.util.JobDescriptionTestUtil;
import com.orio.orioapi.web.controller.JobDescriptionUserController;
import com.orio.orioapi.web.dto.JobDescriptionDto;
import com.orio.orioapi.web.mapper.JobDescriptionMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
public class JobDescriptionUserControllerTest {
    @Mock
    private JobDescriptionService jobDescriptionService;

    @Mock
    private JobDescriptionMapper jobDescriptionMapper;

    @InjectMocks
    private JobDescriptionUserController jobDescriptionUserController;

    @Test
    void shouldGetAllJobDescriptions() {
        // Given
        List<JobDescription> jobDescriptionList = Arrays.asList(new JobDescription(), new JobDescription());
        List<JobDescriptionDto> jobDescriptionDtoList = Arrays.asList(new JobDescriptionDto(), new JobDescriptionDto());

        when(jobDescriptionService.getAllJobDescriptions()).thenReturn(jobDescriptionList);
        when(jobDescriptionMapper.entitiesToDtoList(jobDescriptionList)).thenReturn(jobDescriptionDtoList);

        // When
        ResponseEntity<List<JobDescriptionDto>> responseEntity = jobDescriptionUserController.getAllJobDescriptions();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(jobDescriptionDtoList, responseEntity.getBody());
    }

    @Test
    void shouldGetJobDescriptionById() {
        // Given
        long jobId = 1L;
        JobDescription jobDescription = new JobDescription();
        JobDescriptionDto jobDescriptionDto = new JobDescriptionDto();

        when(jobDescriptionService.getJobDescriptionById(jobId)).thenReturn(Optional.of(jobDescription));
        when(jobDescriptionMapper.entityToDto(jobDescription)).thenReturn(jobDescriptionDto);

        // When
        ResponseEntity<JobDescriptionDto> responseEntity = jobDescriptionUserController.getJobDescriptionById(jobId);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(jobDescriptionDto, responseEntity.getBody());
    }

    @Test
    public void getJobDescriptionByInterests () {
        // Given
        List<String> interests = Arrays.asList("Java", "Programming");

        List<JobDescription> jobDescriptions = Arrays.asList(
                JobDescriptionTestUtil.createJobDescription1(),
                JobDescriptionTestUtil.createJobDescription2()
        );
        when(jobDescriptionService.getJobDescriptionsByInterests(interests)).thenReturn(jobDescriptions);

        List<JobDescriptionDto> jobDescriptionDtoList = Arrays.asList(
                JobDescriptionDtoTestUtil.createJobDescriptionDto1(),
                JobDescriptionDtoTestUtil.createJobDescriptionDto2()
        );
        when(jobDescriptionMapper.entitiesToDtoList(jobDescriptions)).thenReturn(jobDescriptionDtoList);

        // When
        ResponseEntity<List<JobDescriptionDto>> response = jobDescriptionUserController.getJobDescriptionByInterests(interests);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jobDescriptionDtoList, response.getBody());

    }
    
    @Test
    public void getJobDescriptionBySalary () {
        // Given
        String salary = "60 000";

        List<JobDescription> jobDescriptions = Arrays.asList(
                JobDescriptionTestUtil.createJobDescription1(),
                JobDescriptionTestUtil.createJobDescription2()
        );
        when(jobDescriptionService.getJobDescriptionsBySalary(salary)).thenReturn(jobDescriptions);

        List<JobDescriptionDto> jobDescriptionDtoList = Arrays.asList(
                JobDescriptionDtoTestUtil.createJobDescriptionDto1(),
                JobDescriptionDtoTestUtil.createJobDescriptionDto2()
        );
        when(jobDescriptionMapper.entitiesToDtoList(jobDescriptions)).thenReturn(jobDescriptionDtoList);

        // When
        ResponseEntity<List<JobDescriptionDto>> response = jobDescriptionUserController.getJobDescriptionBySalary(salary);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jobDescriptionDtoList, response.getBody());

    }

}
