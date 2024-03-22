package com.orio.orioapi.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class JobDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String job;

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "sectors", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "sector", nullable = false)
    private Set<String> sectors = new HashSet<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "personality_traits", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "personality_trait", nullable = false)
    private Set<String> personalityTraits = new HashSet<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "school_subjects", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "school_subject", nullable = false)
    private Set<String> schoolSubjects = new HashSet<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "interests", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "interest", nullable = false)
    private Set<String> interests = new HashSet<>();

    private String studyDuration;

    private String salary;

    private String socialEnvironment;

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "physical_environments", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "physical_environment", nullable = false)
    private Set<String> physicalEnvironments = new HashSet<>();

    private String description;

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "personality_traits_to_search", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "personality_trait_to_search", nullable = false)
    private Set<String> personalityTraitsToSearch = new HashSet<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "school_subjects_to_search", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "school_subjects_to_search", nullable = false)
    private Set<String> schoolSubjectsToSearch = new HashSet<>();

    private String study;

    private int userScore;

    private String sectorsToSearch;

    private String negativeSentence;

    private int star;

}