package com.jadekler.sheri;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple GameOfLife.
 */
public class SpiralNumbersTest extends TestCase {
    public SpiralNumbersTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SpiralNumbersTest.class);
    }

    public void testTest() {
        SpiralNumbers target = new SpiralNumbers();
        assertTrue(target.test());
    }
}
