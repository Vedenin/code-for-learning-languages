package com.github.vedenin.english;

import com.github.vedenin.english.enums.Pronoun;
import com.github.vedenin.english.enums.TenseForms;

import static com.github.vedenin.english.enums.Pronoun.*;
import static com.github.vedenin.english.enums.TenseForms.*;
import static com.github.vedenin.english.utils.Utils.println;

/**
 * Created by vvedenin on 2/9/2016.
 */
public class PasiveSentenceBuilding {
    private static final String WAS = "was ";
    private static final String WERE = "were ";
    private static final String BEING = "being ";
    private static final String HAD = "had ";
    private static final String BEEN = "been ";
    private static final String AM = "am ";
    private static final String IS = "is ";
    private static final String ARE = "are ";
    private static final String HAVE = "have ";
    private static final String HAS = "has ";
    private static final String WILL = "will ";
    private static final String BE = "be ";

    public static void main(String[] args) {
        println("--- Past ---");
        println("Simple" , buildPastSentence(I, "play", SIMPLE));
        println("Continuous" , buildPastSentence(I, "play", CONTINUOUS));
        println("Perfect" , buildPastSentence(I, "play", PERFECT));
        println();
        println("--- Present ---");
        println("Simple" , buildPresentSentence(I, "play", SIMPLE));
        println("Continuous" , buildPresentSentence(I, "play", CONTINUOUS));
        println("Perfect" , buildPresentSentence(I, "play", PERFECT));
        println();
        println("--- Future ---");
        println("Simple" , buildFutureSentence(I, "play", SIMPLE));
        println("Perfect" , buildFutureSentence(I, "play", PERFECT));
    }


    private static String buildPastSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        String wasOrWere = pronoun == I || pronoun == HE_SHE_IT? WAS: WERE;
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + wasOrWere + verb + "ed";
            case CONTINUOUS:
                return pronoun + wasOrWere + BEING + verb + "ed";
            case PERFECT:
                return pronoun + HAD + BEEN + verb + "ed";
        }
        return null;
    }

    private static String buildPresentSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        String amIsOrAre = pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE;
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + amIsOrAre + verb + "ed";
            case CONTINUOUS:
                return pronoun + amIsOrAre + BEING + verb + "ed";
            case PERFECT:
                return pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + BEEN + verb + "ed";
        }
        return null;
    }

    private static String buildFutureSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + WILL + BE + verb + "ed";
            case PERFECT:
                return pronoun + WILL + HAVE + BEEN + verb + "ed";
        }
        return null;
    }
}
