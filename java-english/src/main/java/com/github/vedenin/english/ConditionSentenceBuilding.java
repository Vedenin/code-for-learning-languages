package com.github.vedenin.english;

import com.github.vedenin.english.enums.Condition;
import com.github.vedenin.english.enums.Pronoun;
import com.github.vedenin.english.enums.Tense;

import static com.github.vedenin.english.enums.Condition.REAL;
import static com.github.vedenin.english.enums.Condition.UNREAL;
import static com.github.vedenin.english.enums.Pronoun.HE_SHE_IT;
import static com.github.vedenin.english.enums.Tense.FUTURE;
import static com.github.vedenin.english.enums.Tense.PAST;
import static com.github.vedenin.english.enums.Tense.PRESENT;

/**
 * Created by vvedenin on 12/22/2016.
 */
public abstract class ConditionSentenceBuilding {
    private static final String SHOULD = "should ";
    private static final String WERE = "were ";
    private static final String HAVE = "have ";
    private static final String HAS = "has ";
    private static final String HAD = "had ";

    private String buildFirstCondition(Condition condition, Tense tense,
                                              String verdInMainStatement,
                                              String verdInSecondStatement) {
        if(condition == REAL && (tense == PRESENT || tense == FUTURE)) {
            verdInMainStatement = convertToFuture(verdInMainStatement);
            verdInSecondStatement = convertToPresent(verdInSecondStatement );
        }
        return verdInMainStatement + ", " + verdInSecondStatement;
    }

    private String buildSecondCondition(Condition condition, Tense tense,
                                       String verdInMainStatement,
                                       String verdInSecondStatement) {
        if(condition == UNREAL && (tense == PRESENT || tense == FUTURE)) {
            verdInMainStatement = SHOULD + verdInMainStatement;
            verdInSecondStatement = verdInSecondStatement.equals("be")? WERE:
                    (verdInSecondStatement + "ed");
        }
        return verdInMainStatement + ", " + verdInSecondStatement;
    }

    private String buildThirdCondition(Condition condition, Tense tense,
                                       Pronoun pronoun,
                                        String verdInMainStatement,
                                        String verdInSecondStatement) {
        if(condition == UNREAL && tense == PAST) {
            verdInMainStatement = SHOULD + (pronoun == HE_SHE_IT ? HAS: HAVE) + verdInMainStatement + "ed";
            verdInSecondStatement = HAD + verdInSecondStatement + "ed";
        }
        return verdInMainStatement + ", " + verdInSecondStatement;
    }

    private String buildAllCondition(Condition condition, Tense tense,
                                       Pronoun pronoun,
                                       String verdInMainStatement,
                                       String verdInSecondStatement) {
        if(condition == REAL) {
            if(tense == PRESENT || tense == FUTURE) { // FirstCondition
                verdInMainStatement = convertToFuture(verdInMainStatement);
                verdInSecondStatement = convertToPresent(verdInSecondStatement);
            } else {
                throw new IllegalStateException(); // Condition doesn't exist
            }
        } else if(condition == UNREAL) {
            if(tense == PRESENT || tense == FUTURE) { // SecondCondition
                verdInMainStatement = SHOULD + verdInMainStatement;
                verdInSecondStatement = verdInSecondStatement.equals("be")? WERE:
                        (verdInSecondStatement + "ed");
            } else { // ThirdCondition
                verdInMainStatement = SHOULD + (pronoun == HE_SHE_IT ? HAS: HAVE) +
                        verdInMainStatement + "ed";
                verdInSecondStatement = HAD + verdInSecondStatement + "ed";
            }
        } else {
            throw new IllegalStateException(); // Condition doesn't exist
        }
        return verdInMainStatement + ", " + verdInSecondStatement;
    }
    /**
     * Return statement in Future tense
     * @param statement
     * @return statement in Future tense
     */
    protected abstract String convertToFuture(String statement);

    /**
     * Return statement in Present tense
     * @param statement
     * @return statement in Present tense
     */
    protected abstract String convertToPresent(String statement);
}
