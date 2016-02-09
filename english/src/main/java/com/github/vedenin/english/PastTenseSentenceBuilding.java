package com.github.vedenin.english;

import com.github.vedenin.english.enums.Pronoun;
import com.github.vedenin.english.enums.TenseForms;
import static com.github.vedenin.english.enums.Pronoun.*;
import static com.github.vedenin.english.enums.TenseForms.*;

/**
 * Created by vvedenin on 2/9/2016.
 */
public class PastTenseSentenceBuilding {
    public static void main(String[] args) {
        System.out.println("--- Positive ---");
        System.out.println("Simple:" + buildPositiveSentence(I, "play", SIMPLE));
        System.out.println("Continuous:" + buildPositiveSentence(I, "play", CONTINUOUS));
        System.out.println("Continuous:" + buildPositiveSentence(WE, "play", CONTINUOUS));
        System.out.println("Perfect:" + buildPositiveSentence(I, "play", PERFECT));
        System.out.println();
        System.out.println("--- Negative ---");
        System.out.println("Simple:" + buildNegativeSentence(I, "play", SIMPLE));
        System.out.println("Continuous:" + buildNegativeSentence(I, "play", CONTINUOUS));
        System.out.println("Continuous:" + buildNegativeSentence(YOU, "play", CONTINUOUS));
        System.out.println("Perfect:" + buildNegativeSentence(I, "play", PERFECT));
        System.out.println();
        System.out.println("--- buildQuestion ---");
        System.out.println("Simple: " + buildQuestion(I, "play", SIMPLE));
        System.out.println("Continuous: " + buildQuestion(I, "play", CONTINUOUS));
        System.out.println("Continuous: " + buildQuestion(THEY, "play", CONTINUOUS));
        System.out.println("Perfect: " + buildQuestion(I, "play", PERFECT));

    }


    private static String buildPositiveSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + verb + "ed";
            case CONTINUOUS:
                return pronoun +
                       (pronoun == I || pronoun == HE_SHE_IT? "was ": "were ") +
                        verb + "ing";
            case PERFECT:
                return pronoun + "had " + verb + "ed";
        }
        throw new IllegalArgumentException("This tenseForms not supported in English");
    }


    private static String buildNegativeSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + "did not " + verb;
            case CONTINUOUS:
                return pronoun +
                        (pronoun == I || pronoun == HE_SHE_IT? "was": "were") +
                         " not " + verb + "ing";
            case PERFECT:
                return pronoun + "had not " + verb + "ed";
        }
        throw new IllegalArgumentException("This tenseForms not supported in English");
    }

    private static String buildQuestion(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return "Did" + pronoun + verb + "?";
            case CONTINUOUS:
                return  (pronoun == I || pronoun == HE_SHE_IT? "Was": "Were") +
                         pronoun + verb + "ing?";
            case PERFECT:
                return "Had" + pronoun + verb + "ed?";
        }
        throw new IllegalArgumentException("This tenseForms not supported in English");
    }

}
