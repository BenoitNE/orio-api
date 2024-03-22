package com.orio.orioapi.persistence.repository.custom.impl;

import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.persistence.repository.custom.JobDescriptionRepositoryCustom;

public class JobDescriptionRepositoryCustomImpl implements JobDescriptionRepositoryCustom{

    @Override
    public Iterable<JobDescription> findWithFilter(String keyWords, String personalityTraitsToSearch, String schoolSubjectsToSearch, String sectorsToSearch, String studyDuration) {
        /*
        A IMPLEMENTER
         */
        return null;
    }
}
