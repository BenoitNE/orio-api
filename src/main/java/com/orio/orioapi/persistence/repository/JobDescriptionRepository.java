package com.orio.orioapi.persistence.repository;


import com.orio.orioapi.persistence.entity.JobDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDescriptionRepository extends JpaRepository<JobDescription, Long> {

    Iterable <JobDescription> findByInterestsIn(List<String> interests);
}
