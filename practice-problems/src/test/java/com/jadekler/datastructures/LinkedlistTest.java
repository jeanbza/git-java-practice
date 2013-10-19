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
public class LinkedListTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LinkedListTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LinkedListTest.class );
    }

    public void testLinkedListSimple() {
        LinkedList list = new LinkedList();

        list.push(5);

        assertEquals(5, list.getFirst().getNum());
    }

    public void testLinkedListNext() {
        LinkedList list = new LinkedList();

        list.push(5);
        list.push(3);

        assertEquals(3, list.getFirst().next().getNum());
    }

    public void testLinkedListPop() {
        LinkedList list = new LinkedList();

        list.push(5);
        list.push(3);
        list.pop();

        assertEquals(5, list.getFirst().getNum());
    }

    public void testLinkedListPopAndPush() {
        LinkedList list = new LinkedList();

        list.push(5);
        list.push(3);
        list.pop();
        list.push(6);
        list.push(7);

        assertEquals(6, list.getFirst().next().getNum());
        assertEquals(7, list.getFirst().next().next().getNum());
    }
}