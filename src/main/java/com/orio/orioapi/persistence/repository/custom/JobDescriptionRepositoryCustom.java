package com.orio.orioapi.persistence.repository.custom;

import com.orio.orioapi.persistence.entity.JobDescription;

public interface JobDescriptionRepositoryCustom {
    Iterable<JobDescription> findWithFilter(String keyWords, String personalityTraitsToSearch, String schoolSubjectsToSearch, String sectorsToSearch, String studyDuration);
}
