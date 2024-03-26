package com.orio.orioapi.util;

import com.orio.orioapi.persistence.entity.JobDescription;

import java.util.Arrays;
import java.util.HashSet;


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
        jobDescription.setSectors(new HashSet<>(Arrays.asList("Technologie", "Développement Logiciel")));
        jobDescription.setPersonalityTraits(new HashSet<>(Arrays.asList("Analytique", "Orienté détail")));
        jobDescription.setSchoolSubjects(new HashSet<>(Arrays.asList("Informatique", "Mathématiques")));
        jobDescription.setInterests(new HashSet<>(Arrays.asList("Programmation", "Résolution de problèmes")));
        jobDescription.setStudyDuration("4 ans");
        jobDescription.setSalary("80 000 $ par an");
        jobDescription.setSocialEnvironment("Collaboratif");
        jobDescription.setPhysicalEnvironments(new HashSet<>(Arrays.asList("Bureau", "Intérieur")));
        jobDescription.setDescription("Description d'emploi pour un ingénieur logiciel.");
        jobDescription.setPersonalityTraitsToSearch(new HashSet<>(Arrays.asList("Analytique")));
        jobDescription.setSchoolSubjectsToSearch(new HashSet<>(Arrays.asList("Informatique")));
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
        jobDescription.setSectors(new HashSet<>(Arrays.asList("Design", "Arts Créatifs")));
        jobDescription.setPersonalityTraits(new HashSet<>(Arrays.asList("Créatif", "Orienté détail")));
        jobDescription.setSchoolSubjects(new HashSet<>(Arrays.asList("Design Graphique", "Beaux-Arts")));
        jobDescription.setInterests(new HashSet<>(Arrays.asList("Arts Visuels", "Typographie")));
        jobDescription.setStudyDuration("3 ans");
        jobDescription.setSalary("60 000 $ par an");
        jobDescription.setSocialEnvironment("Artistique");
        jobDescription.setPhysicalEnvironments(new HashSet<>(Arrays.asList("Studio", "Intérieur")));
        jobDescription.setDescription("Description d'emploi pour un designer graphique.");
        jobDescription.setPersonalityTraitsToSearch(new HashSet<>(Arrays.asList("Créatif")));
        jobDescription.setSchoolSubjectsToSearch(new HashSet<>(Arrays.asList("Design Graphique")));
        jobDescription.setStudy("Design Graphique");
        jobDescription.setUserScore(78);
        jobDescription.setSectorsToSearch("Design");
        jobDescription.setNegativeSentence("Aucun besoin de compétences artistiques");
        jobDescription.setStar(3);

        return jobDescription;
    }
}
