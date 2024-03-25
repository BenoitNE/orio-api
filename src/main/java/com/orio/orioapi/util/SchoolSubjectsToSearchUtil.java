package com.orio.orioapi.util;

public enum SchoolSubjectsToSearchUtil {
    LANGUE("langue"),
    LITTERATURE("littérature"),
    SCIENCES_HUMAINES_ET_SOCIALES("sciences humaines et sociales"),
    MATIERES_SCIENTIFIQUES_ET_DEVELOPPEMENT("matières scientifiques et développement"),
    ARTS("arts"),
    CULTURE("culture"),
    SANTE("santé"),
    BIEN_ETRE("bien-être"),
    ACTIVITES_PHYSIQUES_ET_SPORTIVES("activités physiques et sportives"),
    COMMERCE("commerce"),
    GESTION("gestion"),
    INFORMATIQUE("informatique"),
    TECHNOLOGIE("technologie"),
    ARTISANAT("artisanat"),
    DROIT("droit"),
    MATHEMATIQUE("mathématique");

    private final String label;

    SchoolSubjectsToSearchUtil(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
