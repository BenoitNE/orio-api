package com.orio.orioapi.web.mapper;

import com.orio.orioapi.web.dto.JobDescriptionDto;
import org.mapstruct.Mapper;

import com.orio.orioapi.persistence.entity.JobDescription;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JobDescriptionMapper {

    JobDescriptionMapper INSTANCE = Mappers.getMapper(JobDescriptionMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "userScore", ignore = true),
            @Mapping(target = "sectorsToSearch", ignore = true),
            @Mapping(target = "negativeSentence", ignore = true),
            @Mapping(target = "star", ignore = true),
    })
    JobDescription toEntity(JobDescriptionDto dto);

    List<JobDescription> toEntityList(List<JobDescriptionDto> dtos);

    JobDescriptionDto toDto(JobDescription entity);

    List<JobDescriptionDto> toDtoList(List<JobDescription> entities);
}

