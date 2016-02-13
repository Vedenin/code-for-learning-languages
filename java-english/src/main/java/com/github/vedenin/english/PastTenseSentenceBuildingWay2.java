package com.github.vedenin.english;

import com.github.vedenin.english.enums.Pronoun;
import com.github.vedenin.english.enums.TenseForms;

import static com.github.vedenin.english.enums.Pronoun.*;
import static com.github.vedenin.english.enums.TenseForms.*;
import static com.github.vedenin.english.utils.Utils.println;

/**
 * Created by vvedenin on 2/9/2016.
 */
public class PastTenseSentenceBuildingWay2 {
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
        return pronoun + getAuxiliaryVerb(pronoun, tenseForms, true) +
                getBeenOrEmpty(tenseForms) + verb + getEnding(tenseForms, true);
    }


    private static String buildNegativeSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        return pronoun + getAuxiliaryVerb(pronoun, tenseForms, false) + "not " +
                getBeenOrEmpty(tenseForms) + verb + getEnding(tenseForms, false);
    }

    private static String buildQuestion(Pronoun pronoun, String verb, TenseForms tenseForms) {
        return getAuxiliaryVerb(pronoun, tenseForms, false) + pronoun +
                getBeenOrEmpty(tenseForms) + verb + getEnding(tenseForms, false);
    }

    private static String getAuxiliaryVerb(Pronoun pronoun, TenseForms tenseForms, boolean isPositive) {
        switch (tenseForms) {
            case SIMPLE:
                return isPositive ? "" : DID;
            case CONTINUOUS:
                return (pronoun == I || pronoun == HE_SHE_IT? WAS: WERE);
        }
        return HAD;
    }

    private static String getEnding(TenseForms tenseForms, boolean isPositive) {
        if(tenseForms == SIMPLE) return isPositive? "ed" : "";
        else return tenseForms == PERFECT ? "ed": "ing";
    }

    private static String getBeenOrEmpty(TenseForms tenseForms) {
        return tenseForms == PERFECT_CONTINUOUS ? BEEN: "";
    }



}
