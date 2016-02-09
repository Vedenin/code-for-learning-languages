package com.github.vedenin.english.enums;

/**
 * Created by vedenin on 09.02.16.
 */
public enum Pronoun {
    I("I"),
    YOU("you"),
    HE_SHE_IT ("he/she/it"),
    WE("we"),
    THEY("they");

    private final String text;

    Pronoun(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return " "+ text + " ";
    }
}
