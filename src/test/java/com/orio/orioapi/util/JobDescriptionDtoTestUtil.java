package com.orio.orioapi.util;

import com.orio.orioapi.web.dto.JobDescriptionDto;

import java.util.Arrays;

public class JobDescriptionDtoTestUtil {

    public static JobDescriptionDto createJobDescriptionDto1() {
        JobDescriptionDto jobDescriptionDto = new JobDescriptionDto();
        jobDescriptionDto.setJob("Ingénieur Logiciel");
        jobDescriptionDto.setSectors(Arrays.asList("Technologie", "Développement Logiciel"));
        jobDescriptionDto.setPersonalityTraits(Arrays.asList("Analytique", "Orienté détail"));
        jobDescriptionDto.setSchoolSubjects(Arrays.asList("Informatique", "Mathématiques"));
        jobDescriptionDto.setInterests(Arrays.asList("Programmation", "Résolution de problèmes"));
        jobDescriptionDto.setStudyDuration("4 ans");
        jobDescriptionDto.setSalary("80 000 $ par an");
        jobDescriptionDto.setPhysicalEnvironments(Arrays.asList("Bureau", "Intérieur"));
        jobDescriptionDto.setDescription("Description d'emploi pour un ingénieur logiciel.");
        jobDescriptionDto.setStudy("Informatique");
        jobDescriptionDto.setUserScore(85);
        jobDescriptionDto.setStar(4);

        return jobDescriptionDto;
    }

    public static JobDescriptionDto createJobDescriptionDto2() {
        JobDescriptionDto jobDescriptionDto = new JobDescriptionDto();
        jobDescriptionDto.setJob("Designer Graphique");
        jobDescriptionDto.setSectors(Arrays.asList("Design", "Arts Créatifs"));
        jobDescriptionDto.setPersonalityTraits(Arrays.asList("Créatif", "Orienté détail"));
        jobDescriptionDto.setSchoolSubjects(Arrays.asList("Design Graphique", "Beaux-Arts"));
        jobDescriptionDto.setInterests(Arrays.asList("Arts Visuels", "Typographie"));
        jobDescriptionDto.setStudyDuration("3 ans");
        jobDescriptionDto.setSalary("60 000 $ par an");
        jobDescriptionDto.setPhysicalEnvironments(Arrays.asList("Studio", "Intérieur"));
        jobDescriptionDto.setDescription("Description d'emploi pour un designer graphique.");
        jobDescriptionDto.setStudy("Design Graphique");
        jobDescriptionDto.setUserScore(78);
        jobDescriptionDto.setStar(3);

        return jobDescriptionDto;
    }
}
