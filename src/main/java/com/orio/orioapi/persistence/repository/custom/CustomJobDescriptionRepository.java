package com.orio.orioapi.persistence.repository.custom;

import com.orio.orioapi.persistence.entity.JobDescription;

public interface CustomJobDescriptionRepository {
    Iterable<JobDescription> findByCustomFilters(String keyword, String personalityTraitToSearch, String schoolSubjectToSearch, String sectorToSearch, String studyDuration);
}
