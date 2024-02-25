package com.orio.orioapi.mapper;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.web.dto.JobDescriptionDto;
import com.orio.orioapi.web.mapper.JobDescriptionMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class JobDescriptionMapperTest {

    private JobDescriptionMapper jobDescriptionMapper = Mappers.getMapper(JobDescriptionMapper.class);

    @Test
    public void testToEntity() {
        // Given
        JobDescriptionDto dto = new JobDescriptionDto();
        dto.setJob("Test Job");

        // When
        JobDescription entity = jobDescriptionMapper.toEntity(dto);

        // Then
        assertEquals(dto.getJob(), entity.getJob());

    }

    @Test
    public void testToDto() {
        // Given
        JobDescription entity = new JobDescription();
        entity.setJob("Test Job");

        // When
        JobDescriptionDto dto = jobDescriptionMapper.toDto(entity);

        // Then
        assertEquals(entity.getJob(), dto.getJob());
    }

    @Test
    public void testToEntityList() {
        // Given
        List<JobDescriptionDto> dtos = Arrays.asList(new JobDescriptionDto(), new JobDescriptionDto());

        // When
        List<JobDescription> entities = jobDescriptionMapper.toEntityList(dtos);

        // Then
        assertEquals(dtos.size(), entities.size());
    }

    @Test
    public void testToDtoList() {
        // Given
        List<JobDescription> entities = Arrays.asList(new JobDescription(), new JobDescription());

        // When
        List<JobDescriptionDto> dtos = jobDescriptionMapper.toDtoList(entities);

        // Then
        assertEquals(entities.size(), dtos.size());
    }
}
