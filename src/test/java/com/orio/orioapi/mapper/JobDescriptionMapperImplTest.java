package com.orio.orioapi.mapper;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.web.dto.JobDescriptionDto;
import com.orio.orioapi.web.mapper.impl.JobDescriptionMapperImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class JobDescriptionMapperImplTest {
    @InjectMocks
    private JobDescriptionMapperImpl jobDescriptionMapper;

    @Test
    public void testEntityToDto() {
        // Given
        JobDescription jobDescription = createSampleJobDescription();

        // When
        JobDescriptionDto result = jobDescriptionMapper.entityToDto(jobDescription);

        // Then
        assertEquals(jobDescription.getJob(), result.getJob());
        assertEquals(jobDescription.getSectors(), result.getSectors());
        assertEquals(jobDescription.getPersonalityTraits(), result.getPersonalityTraits());
        assertEquals(jobDescription.getSchoolSubjects(), result.getSchoolSubjects());
        assertEquals(jobDescription.getInterests(), result.getInterests());
        assertEquals(jobDescription.getStudyDuration(), result.getStudyDuration());
        assertEquals(jobDescription.getSalary(), result.getSalary());
        assertEquals(jobDescription.getPhysicalEnvironments(), result.getPhysicalEnvironments());
        assertEquals(jobDescription.getDescription(), result.getDescription());
        assertEquals(jobDescription.getStudy(), result.getStudy());
        assertEquals(jobDescription.getUserScore(), result.getUserScore());
        assertEquals(jobDescription.getStar(), result.getStar());

    }

    @Test
    public void testEntitiesToDtoList() {
        // Given
        List<JobDescription> jobDescriptions = Arrays.asList(createSampleJobDescription(), createSampleJobDescription());

        // When
        List<JobDescriptionDto> result = jobDescriptionMapper.entitiesToDtoList(jobDescriptions);

        // Then
        assertEquals(jobDescriptions.size(), result.size());

        for (int i = 0; i < jobDescriptions.size(); i++) {
            JobDescriptionDto resultDto = result.get(i);
            JobDescription originalJobDescription = jobDescriptions.get(i);

            assertEquals(originalJobDescription.getJob(), resultDto.getJob());
            assertEquals(originalJobDescription.getSectors(), resultDto.getSectors());
            assertEquals(originalJobDescription.getPersonalityTraits(), resultDto.getPersonalityTraits());
            assertEquals(originalJobDescription.getSchoolSubjects(), resultDto.getSchoolSubjects());
            assertEquals(originalJobDescription.getInterests(), resultDto.getInterests());
            assertEquals(originalJobDescription.getStudyDuration(), resultDto.getStudyDuration());
            assertEquals(originalJobDescription.getSalary(), resultDto.getSalary());
            assertEquals(originalJobDescription.getPhysicalEnvironments(), resultDto.getPhysicalEnvironments());
            assertEquals(originalJobDescription.getDescription(), resultDto.getDescription());
            assertEquals(originalJobDescription.getStudy(), resultDto.getStudy());
            assertEquals(originalJobDescription.getUserScore(), resultDto.getUserScore());
            assertEquals(originalJobDescription.getStar(), resultDto.getStar());
        }
    }

    private JobDescription createSampleJobDescription() {
        JobDescription jobDescription = new JobDescription();
        jobDescription.setJob("Ingénieur logiciel");
        jobDescription.setSectors(new HashSet<>(Arrays.asList("Technologie", "Développement logiciel")));
        jobDescription.setPersonalityTraits(new HashSet<>(Arrays.asList("Analytique", "Orienté vers les détails")));
        jobDescription.setSchoolSubjects(new HashSet<>(Arrays.asList("Informatique", "Mathématiques")));
        jobDescription.setInterests(new HashSet<>(Arrays.asList("Programmation", "Résolution de problèmes")));
        jobDescription.setStudyDuration("4");
        jobDescription.setSalary("80000");
        jobDescription.setPhysicalEnvironments(new HashSet<>(Arrays.asList("Bureau", "Espace collaboratif")));
        jobDescription.setDescription("Opportunité passionnante pour un ingénieur logiciel de travailler sur des projets innovants.");
        jobDescription.setStudy("Licence en informatique");
        jobDescription.setUserScore(11);
        jobDescription.setStar(4);

        return jobDescription;
    }
}
