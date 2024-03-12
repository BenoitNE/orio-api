package com.orio.orioapi.util;

import com.orio.orioapi.persistence.entity.JobDescription;

import java.util.Arrays;

public class JobDescriptionTestUtil {

    public static JobDescription createJobDescription(long id) {
        JobDescription jobDescription = new JobDescription();
        jobDescription.setId(id);
        jobDescription.setJob("TestJob");
        return jobDescription;
    }

    public static JobDescription createJobDescription1() {
        JobDescription jobDescription = new JobDescription();
        jobDescription.setJob("Ingénieur Logiciel");
        jobDescription.setSectors(Arrays.asList("Technologie", "Développement Logiciel"));
        jobDescription.setPersonalityTraits(Arrays.asList("Analytique", "Orienté détail"));
        jobDescription.setSchoolSubjects(Arrays.asList("Informatique", "Mathématiques"));
        jobDescription.setInterests(Arrays.asList("Programmation", "Résolution de problèmes"));
        jobDescription.setStudyDuration("4 ans");
        jobDescription.setSalary("80 000 $ par an");
        jobDescription.setSocialEnvironment("Collaboratif");
        jobDescription.setPhysicalEnvironments(Arrays.asList("Bureau", "Intérieur"));
        jobDescription.setDescription("Description d'emploi pour un ingénieur logiciel.");
        jobDescription.setPersonalityTraitsToSearch(Arrays.asList("Analytique"));
        jobDescription.setSchoolSubjectsToSearch(Arrays.asList("Informatique"));
        jobDescription.setStudy("Informatique");
        jobDescription.setUserScore(85);
        jobDescription.setSectorsToSearch("Technologie");
        jobDescription.setNegativeSentence("Aucune compétence en programmation requise");
        jobDescription.setStar(4);

        return jobDescription;
    }

    public static JobDescription createJobDescription2() {
        JobDescription jobDescription = new JobDescription();
        jobDescription.setJob("Designer Graphique");
        jobDescription.setSectors(Arrays.asList("Design", "Arts Créatifs"));
        jobDescription.setPersonalityTraits(Arrays.asList("Créatif", "Orienté détail"));
        jobDescription.setSchoolSubjects(Arrays.asList("Design Graphique", "Beaux-Arts"));
        jobDescription.setInterests(Arrays.asList("Arts Visuels", "Typographie"));
        jobDescription.setStudyDuration("3 ans");
        jobDescription.setSalary("60 000 $ par an");
        jobDescription.setSocialEnvironment("Artistique");
        jobDescription.setPhysicalEnvironments(Arrays.asList("Studio", "Intérieur"));
        jobDescription.setDescription("Description d'emploi pour un designer graphique.");
        jobDescription.setPersonalityTraitsToSearch(Arrays.asList("Créatif"));
        jobDescription.setSchoolSubjectsToSearch(Arrays.asList("Design Graphique"));
        jobDescription.setStudy("Design Graphique");
        jobDescription.setUserScore(78);
        jobDescription.setSectorsToSearch("Design");
        jobDescription.setNegativeSentence("Aucun besoin de compétences artistiques");
        jobDescription.setStar(3);

        return jobDescription;
    }
}
