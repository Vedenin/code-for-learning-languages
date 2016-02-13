package com.github.vedenin.english;

import com.github.vedenin.english.enums.Pronoun;
import com.github.vedenin.english.enums.TenseForms;

import static com.github.vedenin.english.enums.Pronoun.*;
import static com.github.vedenin.english.enums.TenseForms.*;
import static com.github.vedenin.english.utils.Utils.println;

/**
 * Created by vvedenin on 2/9/2016.
 */
public class PresentTenseSentenceBuildingWay2 {
    private static final String AM = "am ";
    private static final String IS = "is ";
    private static final String ARE = "are ";
    private static final String DO = "do ";
    private static final String DOES = "does ";
    private static final String HAVE = "have ";
    private static final String HAS = "has ";
    private static final String BEEN = "been ";


    public static void main(String[] args) {
        println("--- Positive ---");
        println("Simple", buildPositiveSentence(I, "play", SIMPLE));
        println("Continuous", buildPositiveSentence(I, "play", CONTINUOUS));
        println("Continuous", buildPositiveSentence(WE, "play", CONTINUOUS));
        println("Perfect", buildPositiveSentence(I, "play", PERFECT));
        println("Perfect Continuous", buildPositiveSentence(I, "play", PERFECT_CONTINUOUS));

        println();
        println("--- Negative ---");
        println("Simple", buildNegativeSentence(I, "play", SIMPLE));
        println("Continuous", buildNegativeSentence(I, "play", CONTINUOUS));
        println("Continuous", buildNegativeSentence(YOU, "play", CONTINUOUS));
        println("Perfect", buildNegativeSentence(I, "play", PERFECT));
        println("Perfect Continuous", buildNegativeSentence(I, "play", PERFECT_CONTINUOUS));

        println();
        println("--- buildQuestion ---");
        println("Simple", buildQuestion(I, "play", SIMPLE));
        println("Continuous", buildQuestion(I, "play", CONTINUOUS));
        println("Continuous", buildQuestion(THEY, "play", CONTINUOUS));
        println("Perfect", buildQuestion(I, "play", PERFECT));
        println("Perfect Continuous", buildQuestion(I, "play", PERFECT_CONTINUOUS));
    }

    private static String getAuxiliaryVerb(Pronoun pronoun, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return pronoun == HE_SHE_IT ? DOES : DO;
            case CONTINUOUS:
                return pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE;
        }
        return pronoun == HE_SHE_IT ? HAS: HAVE;
    }

    private static String getEnding(Pronoun pronoun, TenseForms tenseForms, boolean isPositive) {
        if(tenseForms == SIMPLE) return isPositive && pronoun == HE_SHE_IT ? "s" : "";
        else return tenseForms == PERFECT ? "ed": "ing";
    }

    private static String getBeenOrEmpty(TenseForms tenseForms) {
        return tenseForms == PERFECT_CONTINUOUS ? BEEN: "";
    }

    private static String buildPositiveSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        return pronoun + getAuxiliaryVerb(pronoun, tenseForms) +
                getBeenOrEmpty(tenseForms) + verb + getEnding(pronoun, tenseForms, true);
    }


    private static String buildNegativeSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        return pronoun + getAuxiliaryVerb(pronoun, tenseForms) + "not " +
                getBeenOrEmpty(tenseForms) + verb + getEnding(pronoun, tenseForms, false);
    }

    private static String buildQuestion(Pronoun pronoun, String verb, TenseForms tenseForms) {
        return getAuxiliaryVerb(pronoun, tenseForms) + pronoun +
                getBeenOrEmpty(tenseForms) + verb + getEnding(pronoun, tenseForms, false);
    }

}
