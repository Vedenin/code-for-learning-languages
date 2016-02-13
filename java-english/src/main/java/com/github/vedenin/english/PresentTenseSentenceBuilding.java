package com.github.vedenin.english;

import com.github.vedenin.english.enums.Pronoun;
import com.github.vedenin.english.enums.TenseForms;

import static com.github.vedenin.english.enums.Pronoun.*;
import static com.github.vedenin.english.enums.TenseForms.*;
import static com.github.vedenin.english.utils.Utils.println;

/**
 * Created by vvedenin on 2/9/2016.
 */
public class PresentTenseSentenceBuilding {
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


    private static String buildPositiveSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + verb + (pronoun == HE_SHE_IT ? "s" : "");
            case CONTINUOUS:
                return pronoun + (pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE) + verb + "ing";
            case PERFECT:
                return pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + verb + "ed";
            case PERFECT_CONTINUOUS:
                return pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + BEEN + verb + "ing";
        }
        return null;
    }


    private static String buildNegativeSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + (pronoun == HE_SHE_IT ? DOES : DO) + "not " + verb;
            case CONTINUOUS:
                return pronoun + (pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE) + "not " + verb + "ing";
            case PERFECT:
                return pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + "not " + verb + "ed";
            case PERFECT_CONTINUOUS:
                return pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + "not " + BEEN + verb + "ing";
        }
        return null;
    }

    private static String buildQuestion(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return (pronoun == HE_SHE_IT ? DOES : DO) + pronoun + verb + "?";
            case CONTINUOUS:
                return (pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE) + pronoun + verb + "ing?";
            case PERFECT:
                return (pronoun == HE_SHE_IT ? HAS: HAVE) + pronoun + verb + "ed?";
            case PERFECT_CONTINUOUS:
                return (pronoun == HE_SHE_IT ? HAS: HAVE) + pronoun + BEEN + verb + "ing?";
        }
        return null;
    }

}
