package com.orio.orioapi.persistence.repository.custom.impl;

import com.orio.orioapi.persistence.repository.custom.CustomJobDescriptionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.orio.orioapi.persistence.entity.JobDescription;

@Repository
public class CustomJobDescriptionRepositoryImpl implements CustomJobDescriptionRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Iterable<JobDescription> findByCustomFilters(String keyword, String personalityTraitToSearch, String schoolSubjectToSearch, String sectorToSearch, String studyDuration) {
        String queryString = "SELECT DISTINCT jd FROM JobDescription jd";

        queryString += " LEFT JOIN jd.sectors sec WITH LOWER(sec) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " LEFT JOIN jd.personalityTraits pt WITH LOWER(pt) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " LEFT JOIN jd.schoolSubjects ss WITH LOWER(ss) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " LEFT JOIN jd.interests interests WITH LOWER(interests) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " LEFT JOIN jd.physicalEnvironments pe WITH LOWER(pe) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " LEFT JOIN jd.personalityTraitsToSearch pttSearch WITH LOWER(pttSearch) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " LEFT JOIN jd.schoolSubjectsToSearch sstSearch WITH LOWER(sstSearch) LIKE LOWER(CONCAT('%', :keyword, '%'))";

        queryString += " WHERE LOWER(jd.job) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " OR LOWER(jd.studyDuration) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " OR LOWER(jd.socialEnvironment) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " OR LOWER(jd.description) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " OR LOWER(jd.study) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " OR LOWER(jd.sectorsToSearch) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        queryString += " OR sec IS NOT NULL";
        queryString += " OR pt IS NOT NULL";
        queryString += " OR ss IS NOT NULL";
        queryString += " OR interests IS NOT NULL";
        queryString += " OR pe IS NOT NULL";
        queryString += " OR pttSearch IS NOT NULL";
        queryString += " OR sstSearch IS NOT NULL";

        Query query = entityManager.createQuery(queryString, JobDescription.class);
        query.setParameter("keyword", keyword);
        System.out.println(query.getResultList());
        return query.getResultList();
    }
}
