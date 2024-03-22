package com.orio.orioapi.persistence.repository;


import com.orio.orioapi.persistence.entity.JobDescription;
import com.orio.orioapi.persistence.repository.custom.JobDescriptionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDescriptionRepository extends JpaRepository<JobDescription, Long>, JobDescriptionRepositoryCustom {

    Iterable <JobDescription> findByInterestsIn(List<String> interests);

    Iterable<JobDescription> findBySectorsIn(List<String> sectors);

    Iterable<JobDescription> findBySalaryContainingIgnoreCase(String salary);

    Iterable <JobDescription> findBySchoolSubjectsIn(List<String> schoolSubjects);

    Iterable<JobDescription> findByJobIn(List<String> job);

    Iterable<JobDescription> findByStudyDurationIn(List<String> studyDuration);
}

