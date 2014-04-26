package com.jadekler.sheri;

import java.util.HashMap;

/**
 * Write some code that will accept an amount and convert it to the appropriate string representation.
 * Example: Convert 2523.04 to "Two thousand five hundred twenty-three and 04/100 dollars"
 */
public class NumberWords {
    char inputString[];
    String singleDigits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public NumberWords(float inputNumber) {
        this.inputString = Float.toString(inputNumber).toCharArray();
    }

    public String compile() {
        String compiledString = "";
        boolean beforeDecimal = true;

        for (int i = 0; i < this.inputString.length; i++) {
            char charChar = this.inputString[i];

            if (charChar != '.') {
                int charInt = Character.getNumericValue(charChar);

                if (beforeDecimal) {
                    compiledString += singleDigits[charInt];
                } else {
                    compiledString += " and "+charChar+"/10";
                }
            } else {
                beforeDecimal = false;
            }
        }
        
        return compiledString;
    }
}