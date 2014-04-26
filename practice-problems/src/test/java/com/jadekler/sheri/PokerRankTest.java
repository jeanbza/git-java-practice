package com.jadekler.sheri;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple GameOfLife.
 */
public class PokerRankTest extends TestCase {
    public PokerRankTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PokerRankTest.class);
    }

    public void testTest() {
        PokerRank target = new PokerRank();
        assertTrue(target.test());
    }
}
