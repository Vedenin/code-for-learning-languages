package com.github.vedenin.english;

import com.github.vedenin.english.enums.Pronoun;
import com.github.vedenin.english.enums.TenseForms;

import static com.github.vedenin.english.enums.Pronoun.*;
import static com.github.vedenin.english.enums.TenseForms.*;
import static com.github.vedenin.english.utils.Utils.println;

/**
 * Created by vvedenin on 2/9/2016.
 */
public class FutureTenseSentenceBuildingWay2 {
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

    private static String getEnding(TenseForms tenseForms) {
        if(tenseForms == SIMPLE) return "";
        else return tenseForms == PERFECT ? "ed": "ing";
    }

    private static String getAuxiliary(TenseForms tenseForms) {
        switch (tenseForms) {
            case SIMPLE:
                return "";
            case CONTINUOUS:
                return BE;
            case PERFECT:
                return HAVE;
        }
        return HAVE + BEEN;
    }

    private static String buildPositiveSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        return pronoun + WILL + getAuxiliary(tenseForms) + verb + getEnding(tenseForms);
    }


    private static String buildNegativeSentence(Pronoun pronoun, String verb, TenseForms tenseForms) {
        return pronoun + WILL + "not " + getAuxiliary(tenseForms) + verb + getEnding(tenseForms);
    }

    private static String buildQuestion(Pronoun pronoun, String verb, TenseForms tenseForms) {
        return WILL + pronoun + getAuxiliary(tenseForms) + verb + getEnding(tenseForms);
    }

}
