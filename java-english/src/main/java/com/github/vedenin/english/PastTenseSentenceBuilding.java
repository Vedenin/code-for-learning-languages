package com.github.vedenin.english;

import com.github.vedenin.english.enums.Pronoun;
import com.github.vedenin.english.enums.TenseForms;

import static com.github.vedenin.english.utils.Utils.println;
import static com.github.vedenin.english.enums.Pronoun.*;
import static com.github.vedenin.english.enums.TenseForms.*;

/**
 * Created by vvedenin on 2/9/2016.
 */
public class PastTenseSentenceBuilding {
    private static final String WAS = "was ";
    private static final String WERE = "were ";
    private static final String DID = "did ";
    private static final String HAD = "had ";
    private static final String BEEN = "been ";


    public static void main(String[] args) {
        println("--- Positive ---");
        println("Simple" , buildPositiveSentence(I, "play", SIMPLE));
        println("Continuous" , buildPositiveSentence(I, "play", CONTINUOUS));
        println("Continuous" , buildPositiveSentence(WE, "play", CONTINUOUS));
        println("Perfect" , buildPositiveSentence(I, "play", PERFECT));
        println("Perfect Continuous" , buildPositiveSentence(I, "play", PERFECT_CONTINUOUS));

        println();
        println("--- Negative ---");
        println("Simple" , buildNegativeSentence(I, "play", SIMPLE));
        println("Continuous" , buildNegativeSentence(I, "play", CONTINUOUS));
        println("Continuous" , buildNegativeSentence(YOU, "play", CONTINUOUS));
        println("Perfect" , buildNegativeSentence(I, "play", PERFECT));
        println("Perfect Continuous" , buildNegativeSentence(I, "play", PERFECT_CONTINUOUS));

        println();
        println("--- buildQuestion ---");
        println("Simple" , buildQuestion(I, "play", SIMPLE));
        println("Continuous" , buildQuestion(I, "play", CONTINUOUS));
        println("Continuous" , buildQuestion(THEY, "play", CONTINUOUS));
        println("Perfect" , buildQuestion(I, "play", PERFECT));
        println("Perfect Continuous" , buildQuestion(I, "play", PERFECT_CONTINUOUS));
    }


    private static String buildPositiveSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + verb + "ed";
            case CONTINUOUS:
                return pronoun + (pronoun == I || pronoun == HE_SHE_IT? WAS: WERE) + verb + "ing";
            case PERFECT:
                return pronoun + HAD + verb + "ed";
            case PERFECT_CONTINUOUS:
                return pronoun + HAD + BEEN + verb + "ing";
        }
        throw new IllegalArgumentException("This tenseForms not supported in English");
    }


    private static String buildNegativeSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + DID +"not " + verb;
            case CONTINUOUS:
                return pronoun + (pronoun == I || pronoun == HE_SHE_IT? WAS: WERE) + "not " + verb + "ing";
            case PERFECT:
                return pronoun + HAD + "not " + verb + "ed";
            case PERFECT_CONTINUOUS:
                return pronoun + HAD + "not " + BEEN + verb + "ing";
        }
        throw new IllegalArgumentException("This tenseForms not supported in English");
    }

    private static String buildQuestion(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return DID + pronoun + verb + "?";
            case CONTINUOUS:
                return  (pronoun == I || pronoun == HE_SHE_IT? WAS: WERE) + pronoun + verb + "ing?";
            case PERFECT:
                return HAD + pronoun + verb + "ed?";
            case PERFECT_CONTINUOUS:
                return HAD + pronoun + BEEN + verb + "ing?";
        }
        throw new IllegalArgumentException("This tenseForms not supported in English");
    }

}
