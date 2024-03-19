package com.orio.orioapi.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;


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
    private List<String> sectors = new ArrayList<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "personality_traits", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "personality_trait", nullable = false)
    private List<String> personalityTraits = new ArrayList<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "school_subjects", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "school_subject", nullable = false)
    private List<String> schoolSubjects = new ArrayList<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "interests", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "interest", nullable = false)
    private List<String> interests = new ArrayList<>();

    private String studyDuration;

    private String salary;

    private String socialEnvironment;

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "physical_environments", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "physical_environment", nullable = false)
    private List<String> physicalEnvironments = new ArrayList<>();

    private String description;

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "personality_traits_to_search", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "personality_trait_to_search", nullable = false)
    private List<String> personalityTraitsToSearch = new ArrayList<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "school_subjects_to_search", joinColumns = @JoinColumn(name = "job_description_id"))
    @Column(name = "school_subjects_to_search", nullable = false)
    private List<String> schoolSubjectsToSearch = new ArrayList<>();

    private String study;

    private int userScore;

    private String sectorsToSearch;

    private String negativeSentence;

    private int star;

}