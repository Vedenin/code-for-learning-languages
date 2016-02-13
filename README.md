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
