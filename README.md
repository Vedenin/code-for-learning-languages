### Project to learn different natural languages (English, Polish and so on) using mnemonic rules with Java code
This is project for use mnemonic rules as programing code to learn grammar rules of different natural languages (English, Polish and so on):

For example, a mnemonic rule for all Past tense in English using Java code is just: 

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
        
It's may be easy way to learn grammar for programmer then traditional method.    

#### Positive sentence

Tense	 | 	Simple	 | 	Continuous  | Perfect | Perfect Continuous
-------- | 	-------- | 	----------- | 	----- | 	-----------
Past	 | 	`pronoun + verb + "ed"`	 | 	`pronoun + (pronoun == I || pronoun == HE_SHE_IT? WAS: WERE) + verb + "ing"`  | `pronoun + HAD + verb + "ed"` | `pronoun + HAD + BEEN + verb + "ing"`
Present	 | 	`pronoun + verb + (pronoun == HE_SHE_IT ? "s" : "")`	 | `pronoun + (pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE) + verb + "ing"`  | `pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + verb + "ed"` | `pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + BEEN + verb + "ing"`
Future	 | 	`pronoun + WILL + verb`	 | `pronoun +  WILL + BE + verb + "ing"`  | `pronoun + WILL +  HAVE + verb + "ed"` | `pronoun +  WILL +  HAVE + BEEN + verb + "ing"`
Future In Past | 	`pronoun + WOULD + BE + verb + "ing"`	 | `pronoun + WOULD + BE + verb + "ing"`  | `pronoun + WOULD +  HAVE + verb + "ed"` | `pronoun + WOULD +  HAVE + BEEN + verb + "ing"`

#### Negative sentence

Tense	 | 	Simple	 | 	Continuous  | Perfect | Perfect Continuous
-------- | 	-------- | 	----------- | 	----- | 	-----------
Past	 | 	`pronoun + DID +"not " + verb`	 | 	`pronoun + (pronoun == I || pronoun == HE_SHE_IT? WAS: WERE) + "not " + verb + "ing"`  | `pronoun + HAD + "not " + verb + "ed"` | `pronoun + HAD + "not " + BEEN + verb + "ing"`
Present	 | 	`pronoun + (pronoun == HE_SHE_IT ? DOES : DO) + "not " + verb`	 | `pronoun + (pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE) + "not " + verb + "ing"`  | `pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + "not " + verb + "ed"` | `pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + "not " + BEEN + verb + "ing"`
Future	 | 	`pronoun + WILL + "not " + verb`	 | `pronoun + WILL + "not "  + BE + verb + "ing"`  | `pronoun + WILL  + "not " + HAVE + verb + "ed"` | `pronoun + WILL + "not " + HAVE + BEEN + verb + "ing"`

#### Questions
Tense	 | 	Simple	 | 	Continuous  | Perfect | Perfect Continuous
-------- | 	-------- | 	----------- | 	----- | 	-----------
Past	 | 	`DID + pronoun + verb + "?"`	 | 	`(pronoun == I || pronoun == HE_SHE_IT? WAS: WERE) + pronoun + verb + "ing?"`  | `HAD + pronoun + verb + "ed?"` | `HAD + pronoun + BEEN + verb + "ing?"`
Present	 | 	`(pronoun == HE_SHE_IT ? DOES : DO) + pronoun + verb + "?"`	 | `(pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE) + pronoun + verb + "ing?"`  | `(pronoun == HE_SHE_IT ? HAS: HAVE) + pronoun + verb + "ed?"` | `(pronoun == HE_SHE_IT ? HAS: HAVE) + pronoun + BEEN + verb + "ing?"`
Future	 | 	`WILL + pronoun + verb + "?"`	 | `WILL + pronoun + BE + verb + "ing?"`  | `WILL + pronoun + HAVE + verb + "ed?"` | `WILL + pronoun + HAVE + BEEN + verb + "ing?"`

#### Passive
Tense	 | 	Simple	 | 	Continuous  | Perfect
-------- | 	-------- | 	----------- | 	-----
Past	 | 	`pronoun + (pronoun == I || pronoun == HE_SHE_IT? WAS: WERE) + verb + "ed"`	 | 	`pronoun + (pronoun == I || pronoun == HE_SHE_IT? WAS: WERE) + BEING + verb + "ed"`  | `pronoun + HAD + BEEN + verb + "ed"`
Present	 | 	`pronoun + (pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE) + verb + "ed"`	 | `pronoun + (pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE) + BEING + verb + "ed"` | `pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + BEEN + verb + "ed"`
Future	 | 	`pronoun + WILL + BE + verb + "ed"`	 | NULL  | `pronoun + WILL + HAVE + BEEN + verb + "ed"`

####  FutureInPast

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
        
####  Conditions

        if(condition == REAL) {
            if(tense == PRESENT || tense == FUTURE) { // FirstCondition
                verdInMainStatement = convertToFuture(verdInMainStatement);
                verdInSecondStatement = convertToPresent(verdInSecondStatement);
            } else {
                throw new IllegalStateException(); // Condition isn't exist
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
            throw new IllegalStateException(); // Condition isn't exist
        }
        
        
More info for English see [this](https://github.com/Vedenin/code-for-learning-languages/tree/master/java-english/src/main/java/com/github/vedenin/english)   

**P.S.** I'll happy if you add new natural and programm languages to this project. 
