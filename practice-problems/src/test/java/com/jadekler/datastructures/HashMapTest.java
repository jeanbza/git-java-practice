package com.jadekler.datastructures;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HashMapTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HashMapTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HashMapTest.class );
    }

    public void testHashMapStringString() {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("test_key", "test_value");
        map.put("one", "this is a longer string");
        map.put("boom", "bam");
        map.put("this is a much longer key to test edge cases", "this is a much longer value to test edge cases");

        assertEquals(map.get("test_key"), "test_value");
        assertEquals(map.get("one"), "this is a longer string");
        assertEquals(map.get("boom"), "bam");
        assertEquals(map.get("this is a much longer key to test edge cases"), "this is a much longer value to test edge cases");
    }

    public void testHashMapStringInt() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(5, "test_value");
        map.put(3, "this is a longer string");
        map.put(9821, "bam");
        map.put(1000, "this is a much longer value to test edge cases");

        assertEquals(map.get(5), "test_value");
        assertEquals(map.get(3), "this is a longer string");
        assertEquals(map.get(9821), "bam");
        assertEquals(map.get(1000), "this is a much longer value to test edge cases");
    }
}