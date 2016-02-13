package com.github.vedenin.english;

import com.github.vedenin.english.enums.Pronoun;
import com.github.vedenin.english.enums.TenseForms;

import static com.github.vedenin.english.enums.Pronoun.*;
import static com.github.vedenin.english.enums.TenseForms.*;
import static com.github.vedenin.english.utils.Utils.println;

/**
 * Created by vvedenin on 2/9/2016.
 */
public class FutureInPastSentenceBuilding {
    private static final String WOULD = "would (should) ";
    private static final String BE = "be ";
    private static final String HAVE = "have ";
    private static final String BEEN = "been ";


    public static void main(String[] args) {
        println("--- Positive ---");
        println("Simple", "I said " + buildPositiveSentence(I, "play", SIMPLE));
        println("Continuous", "I said " +buildPositiveSentence(I, "play", CONTINUOUS));
        println("Perfect", "I said " +buildPositiveSentence(I, "play", PERFECT));
        println("Perfect Continuous", "I said " +buildPositiveSentence(I, "play", PERFECT_CONTINUOUS));
    }


    private static String buildPositiveSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return pronoun + WOULD + verb;
            case CONTINUOUS:
                return pronoun + WOULD + BE + verb + "ing";
            case PERFECT:
                return pronoun + WOULD +  HAVE + verb + "ed";
            case PERFECT_CONTINUOUS:
                return pronoun + WOULD +  HAVE + BEEN + verb + "ing";
        }
        return null;
    }


}
