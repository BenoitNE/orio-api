package com.orio.orioapi.util;

public enum StudyDurationUtil {
    COURTE("courte"),
    MOYENNE("moyenne"),
    LONGUE("longue");

    private final String label;

    StudyDurationUtil(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
