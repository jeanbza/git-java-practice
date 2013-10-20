package com.jadekler.datastructures;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.Random;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class StackTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StackTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StackTest.class );
    }

    public void testStackSimple() {
        Stack list = new Stack();

        list.push(5);

        assertEquals(5, list.pop().getNum());
    }

    public void testStackNext() {
        Stack list = new Stack();

        list.push(5);
        list.push(3);

        assertEquals(3, list.pop().getNum());
    }

    public void testStackPop() {
        Stack list = new Stack();

        list.push(5);
        list.push(3);
        list.pop();

        assertEquals(5, list.getTop().getNum());
        assertEquals(5, list.getBottom().getNum());
    }

    public void testStackPopAndPush() {
        Stack list = new Stack();

        list.push(5);
        list.push(3);
        list.pop();
        list.push(6);
        list.push(7);

        assertEquals(5, list.getBottom().getNum());
        assertEquals(7, list.getTop().getNum());
    }
}