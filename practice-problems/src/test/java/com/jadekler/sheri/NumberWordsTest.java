package com.jadekler.sheri;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple GameOfLife.
 */
public class NumberWordsTest extends TestCase {
    public NumberWordsTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(NumberWordsTest.class);
    }

    public void testSimple() {
        NumberWords translator = new NumberWords(3);
        assertEquals(translator.compile(), "three and 0/10");
    }

    public void testTeens() {
        NumberWords translator = new NumberWords(13);
        assertEquals(translator.compile(), "thirteen and 0/10");

        translator = new NumberWords(10);
        assertEquals(translator.compile(), "ten and 0/10");

        translator = new NumberWords(19);
        assertEquals(translator.compile(), "nineteen and 0/10");
    }

    public void testHundred() {
        NumberWords translator = new NumberWords(213);
        assertEquals(translator.compile(), "two hundred and thirteen and 0/10");

        translator = new NumberWords(100);
        assertEquals(translator.compile(), "one hundred and 0/10");

        translator = new NumberWords(999);
        assertEquals(translator.compile(), "nine hundred and ninety-nine and 0/10");
    }

    public void testThousand() {
        NumberWords translator = new NumberWords(5213);
        assertEquals(translator.compile(), "five thousand, two hundred and thirteen and 0/10");

        translator = new NumberWords(1000);
        assertEquals(translator.compile(), "one thousand and 0/10");

        translator = new NumberWords(10000);
        assertEquals(translator.compile(), "ten thousand and 0/10");

        translator = new NumberWords(100000);
        assertEquals(translator.compile(), "one hundred thousand and 0/10");

        translator = new NumberWords(999999);
        assertEquals(translator.compile(), "nine hundred and ninety-nine thousand, nine hundred and ninety-nine and 0/10");
    }

    public void testMillion() {
        NumberWords translator = new NumberWords(1000000);
        assertEquals(translator.compile(), "one million and 0/10");

        translator = new NumberWords(5000005);
        assertEquals(translator.compile(), "five million five and 0/10");

        translator = new NumberWords(999999999);
        assertEquals(translator.compile(), "nine hundred and ninety-nine million, nine hundred and ninety-nine thousand, nine hundred and ninety-nine and 0/10");
    }
}
