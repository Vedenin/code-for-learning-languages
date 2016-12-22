package com.github.vedenin.english.enums;

/**
 * Created by vvedenin on 12/22/2016.
 */
public enum Condition {
    REAL("Real"),
    UNREAL("Unreal");

    private final String text;

    Condition(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return " "+ text + " ";
    }
}

