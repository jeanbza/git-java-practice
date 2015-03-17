package com.jadekler.sheri;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write some code that will accept an amount and convert it to the appropriate string representation.
 * Example: Convert 2523.04 to "Two thousand five hundred twenty-three and 04/100 dollars"
 */
public class NumberWords {
    String inputStringBeforePeriod;
    char inputAfterPeriod[];
    String simpleDigits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String tensDigits[] = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String largerDigits[] = {"thousand", "million", "billion", "trillion"};

    public NumberWords(float inputNumber) {
        inputStringBeforePeriod = Float.toString(inputNumber).split("\\.")[0];
        inputAfterPeriod = Float.toString(inputNumber).split("\\.")[1].toCharArray();
    }

    public String compile() {
        String compiledString = "";
        boolean beforeDecimal = true;

        ArrayList<String> blocks = regexMatchPattern(reverseString(inputStringBeforePeriod), "([0-9]{1,3})");

        // We're iterating backwards over our string because we reversed our string (so, actually, we're
        // iterating forwards =) )
        for (int i = blocks.size()-1; i >= 0; i--) {
            String block = reverseString(blocks.get(i));
            String hundredCompiled = compileHundred(block);

            // For things that aren't properly chained from one block to another (e.g. 5000005), manually
            // addUndirected in the missing space
            if (hundredCompiled != "") {
                if (compiledString != "" && compiledString.charAt(compiledString.length()-1) != ' ') {
                    compiledString += " ";
                }
            }

            compiledString += hundredCompiled;

            // We tack on 'thousand', 'million', etc if we're further than the last 3 block and there is
            // something other than 000 in this block
            if (i > 0 && Integer.parseInt(blocks.get(i)) > 0) {
                compiledString += " "+largerDigits[i-1];

                // Check if there's something ahead of this point
                if (Integer.parseInt(blocks.get(i-1)) > 0) {
                    compiledString += ", ";
                }
            }
        }

        char charChar = this.inputAfterPeriod[0];
        compiledString += " and "+charChar+"/10";

        System.out.println(compiledString);

        return compiledString;
    }

    /**
     * This function reverses a string
     */
    public String reverseString(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * This function compiles something of the form XXX (as in, 953, 3, 75, 123, 100, etc) into a word
     */
    public String compileHundred(String hundredBlock) {
        String resultantString = "";

        // Left pad first
        hundredBlock = String.format("%03d", Integer.parseInt(hundredBlock));

        int firstDigit = Character.getNumericValue(hundredBlock.charAt(0));
        int lastTwoDigits = Integer.parseInt(hundredBlock.substring(1,3));

        if (firstDigit > 0) {
            resultantString = simpleDigits[firstDigit]+" hundred";

            if (lastTwoDigits > 0) {
                resultantString += " and ";
            }
        }

        if (lastTwoDigits > 19) {
            int firstOfLastTwo = lastTwoDigits / 10;
            int secondOfLastTwo = lastTwoDigits % 10;

            if (firstOfLastTwo > 0) {
                resultantString += tensDigits[firstOfLastTwo-2];
            }

            if (secondOfLastTwo > 0) {
                resultantString += "-"+simpleDigits[secondOfLastTwo];
            }
        } else if (lastTwoDigits > 0) {
            resultantString += simpleDigits[lastTwoDigits];
        }

        return resultantString;
    }

    /**
     * This function regexs a string with a pattern and returns all matches in an arraylist
     */
    public ArrayList<String> regexMatchPattern(String haystack, String pattern) {
        ArrayList<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile(pattern).matcher(haystack);

        while (m.find()) {
            allMatches.add(m.group(1));
        }

        return allMatches;
    }
}