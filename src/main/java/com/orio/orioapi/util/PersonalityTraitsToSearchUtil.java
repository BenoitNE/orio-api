package com.orio.orioapi.util;

public enum PersonalityTraitsToSearchUtil {
    ADAPTABILITE_ET_POLYVALENCE("adaptabilité et polyvalence"),
    ANALYSE_ET_REFLEXION("analyse et réflexion"),
    ARTISTIQUE("artistique"),
    BONNE_CAPACITE_PHYSIQUE("bonne capacité physique"),
    COMMUNICATION_ET_INTERACTION_SOCIALE("communication et interaction sociale"),
    CREATIVITE_ET_INNOVATION("créativité et innovation"),
    GESTION_ET_ORGANISATION("gestion et organisation"),
    INTELLIGENCE_EMOTIONNELLE("intelligence émotionnelle"),
    INTEGRITE_ET_ETHIQUE("intégrité et éthique"),
    LEADERSHIP_ET_INFLUENCE("leadership et influence"),
    PERSEVERANCE_ET_DETERMINATION("persévérance et détermination"),
    RESILIENCE_ET_GESTION_DU_STRESS("résilience et gestion du stress");

    private final String label;

    PersonalityTraitsToSearchUtil(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
