package com.jadekler.sheri;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple GameOfLife.
 */
public class GameOfLifeTest extends TestCase {
    public GameOfLifeTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(GameOfLifeTest.class);
    }

    public void testTest() {
        GameOfLife target = new GameOfLife();
        assertTrue(target.test());
    }
}
