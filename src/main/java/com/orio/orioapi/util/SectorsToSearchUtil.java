package com.orio.orioapi.util;

public enum SectorsToSearchUtil {
    AGRICOLE("agricole"),
    MANUFACTURIER("manufacturier"),
    CONSTRUCTION("construction"),
    ENERGIE("énergie"),
    EDUCATION("éducation"),
    SANTE("santé"),
    SERVICES_FINANCIERS("services financiers"),
    HOTELLERIE_ET_TOURISME("hôtellerie et Tourisme"),
    INFORMATION_ET_COMMUNICATION("information et Communication"),
    TECHNOLOGIE_ET_INFORMATIQUE("technologie et Informatique"),
    SERVICES_PROFESSIONNELS_SCIENTIFIQUE_ET_TECHNIQUES("services professionnels, scientifiques et techniques"),
    SERVICES_PUBLICS_ET_SOCIAUX("services publics et sociaux"),
    TRANSPORTS_ET_LOGISTIQUE("transports et Logistique"),
    COMMERCE_DE_GROS_ET_DE_DETAIL("commerce de gros et de détail"),
    IMMOBILIER("immobilier"),
    ART_SPECTACLE_ET_LOISIRS("art, Spectacle et Loisirs"),
    RESTAURATION("restauration"),
    EXPLOITATION_MINIERE_ET_EXTRACTION("exploitation minière et Extraction"),
    ASSURANCE_ET_PENSIONS("assurance et Pensions"),
    ENVIRONNEMENT_ET_GESTION_DES_DECHETS("environnement et Gestion des déchets"),
    RECHERCHE_ET_DEVELOPPEMENT("recherche et Développement"),
    GESTION_COMPTABILITE_ET_ADMINISTRATION("gestion, comptabilité et administration");

    private final String label;

    SectorsToSearchUtil(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
