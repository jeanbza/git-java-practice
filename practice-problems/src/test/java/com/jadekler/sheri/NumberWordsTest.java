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
        NumberWords translator = new NumberWords(0);
        assertEquals(translator.compile(), "");
    }
}
