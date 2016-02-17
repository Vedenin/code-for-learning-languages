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


Tense	 | 	Simple	 | 	Continuous  | Perfect | Perfect Continuous
-------- | 	-------- | 	----------- | 	----- | 	-----------
Past	 | 	pronoun + verb + "ed"	 | 	pronoun + (pronoun == I || pronoun == HE_SHE_IT? WAS: WERE) + verb + "ing"  | pronoun + HAD + verb + "ed" | pronoun + HAD + BEEN + verb + "ing"
Present	 | 	pronoun + verb + (pronoun == HE_SHE_IT ? "s" : "")	 | pronoun + (pronoun == I ? AM : pronoun == HE_SHE_IT ? IS : ARE) + verb + "ing"  | pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + verb + "ed" | pronoun + (pronoun == HE_SHE_IT ? HAS: HAVE) + BEEN + verb + "ing"
Future	 | 	pronoun + WILL + verb	 | pronoun +  WILL + BE + verb + "ing"  | pronoun + WILL +  HAVE + verb + "ed" | pronoun +  WILL +  HAVE + BEEN + verb + "ing"