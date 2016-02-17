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

