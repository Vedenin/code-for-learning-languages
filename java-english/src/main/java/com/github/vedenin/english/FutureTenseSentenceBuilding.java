package com.github.vedenin.english;

import com.github.vedenin.english.enums.Pronoun;
import com.github.vedenin.english.enums.TenseForms;

import static com.github.vedenin.english.enums.Pronoun.*;
import static com.github.vedenin.english.enums.TenseForms.*;
import static com.github.vedenin.english.utils.Utils.println;

/**
 * Created by vvedenin on 2/9/2016.
 */
public class FutureTenseSentenceBuilding {
    private static final String WILL = "will ";
    private static final String BE = "be ";
    private static final String HAVE = "have ";
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
                return pronoun + WILL + verb;
            case CONTINUOUS:
                return pronoun +  WILL + BE + verb + "ing";
            case PERFECT:
                return pronoun + WILL +  HAVE + verb + "ed";
            case PERFECT_CONTINUOUS:
                return pronoun +  WILL +  HAVE + BEEN + verb + "ing";
        }
        return null;
    }


    private static String buildNegativeSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + WILL + "not " + verb;
            case CONTINUOUS:
                return pronoun + WILL + "not "  + BE + verb + "ing";
            case PERFECT:
                return pronoun + WILL  + "not " + HAVE + verb + "ed";
            case PERFECT_CONTINUOUS:
                return pronoun + WILL + "not " + HAVE + BEEN + verb + "ing";
        }
        return null;
    }

    private static String buildQuestion(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return WILL + pronoun + verb + "?";
            case CONTINUOUS:
                return WILL + pronoun + BE + verb + "ing?";
            case PERFECT:
                return WILL + pronoun + HAVE + verb + "ed?";
            case PERFECT_CONTINUOUS:
                return WILL + pronoun + HAVE + BEEN + verb + "ing?";
        }
        return null;
    }

}
