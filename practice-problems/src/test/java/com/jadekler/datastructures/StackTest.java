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

    public void testStackEmpty() {
        Stack stack = new Stack();

        assertTrue(stack.isEmpty());
    }

    public void testStackSimple() {
        Stack stack = new Stack();

        stack.push(5);

        assertEquals(5, stack.pop().getNum());
    }

    public void testStackNext() {
        Stack stack = new Stack();

        stack.push(5);
        stack.push(3);

        assertEquals(3, stack.pop().getNum());
    }

    public void testStackPop() {
        Stack stack = new Stack();

        stack.push(5);
        stack.push(3);
        stack.pop();

        assertEquals(5, stack.getTop().getNum());
        assertEquals(5, stack.getBottom().getNum());
    }

    public void testStackPopAndPush() {
        Stack stack = new Stack();

        stack.push(5);
        stack.push(3);
        stack.pop();
        stack.push(6);
        stack.push(7);

        assertEquals(5, stack.getBottom().getNum());
        assertEquals(7, stack.getTop().getNum());
    }
}