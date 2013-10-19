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
public class BinaryTreeTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BinaryTreeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BinaryTreeTest.class );
    }

    public void testBinaryTreeEmptyStr() {
        BinaryTree tree = new BinaryTree();

        assertEquals("Tree is empty", tree.toString());
    }

    public void testBinaryTreeEmptyArr() {
        BinaryTree tree = new BinaryTree();

        int[] expected = new int[0];

        assertTrue(Arrays.equals(expected, tree.toArray()));
    }

    public void testBinaryTreeSimpleStr() {
        BinaryTree tree = new BinaryTree();
        tree.push(9);

        assertEquals("9 ", tree.toString());
    }

    public void testBinaryTreeSimpleArr() {
        BinaryTree tree = new BinaryTree();
        tree.push(9);

        int[] expected = {9};

        assertTrue(Arrays.equals(expected, tree.toArray()));
    }

    public void testBinaryTreeLargeStr() {
        BinaryTree tree = new BinaryTree();
        tree.push(9);
        tree.push(4);
        tree.push(2);
        tree.push(3);
        tree.push(10);

        assertEquals("2 3 4 9 10 ", tree.toString());
    }

    public void testBinaryTreeLargeArr() {
        BinaryTree tree = new BinaryTree();
        tree.push(9);
        tree.push(4);
        tree.push(2);
        tree.push(3);
        tree.push(10);

        int[] expected = {2,3,4,9,10};

        assertTrue(Arrays.equals(expected, tree.toArray()));
    }
}