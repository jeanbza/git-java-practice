package com.jadekler.sheri;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple GameOfLife.
 */
public class TemplatingTest extends TestCase {
    public TemplatingTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TemplatingTest.class);
    }

    public void testEmptyArgs() {
        HashMap<String,String> args = new HashMap<String,String>();
        String expected = "";

        Templating template = new Templating(args, "");
        String result = template.compile();

        assertEquals(result, expected);
    }

    public void testSimple() {
        HashMap<String,String> args = new HashMap<String,String>();
        args.put("name", "Jim");
        String expected = "Hello Jim";

        Templating template = new Templating(args, "Hello ${name}");
        String result = template.compile();

        assertEquals(result, expected);
    }

    public void testNesting() {
        HashMap<String,String> args = new HashMap<String,String>();
        args.put("name", "Jim");
        args.put("eyecolor", "Blue");
        String expected = "Hello Jim, your eyes are ${Blue}";

        Templating template = new Templating(args, "Hello ${name}, your eyes are ${${eyecolor}}");
        String result = template.compile();

        assertEquals(result, expected);
    }

    public void testSomeUsed() {
        HashMap<String,String> args = new HashMap<String,String>();
        args.put("name", "Jim");
        args.put("eyecolor", "Blue");
        String expected = "Hello Jim";

        Templating template = new Templating(args, "Hello ${name}");
        String result = template.compile();

        assertEquals(result, expected);
    }

    public void testNoneUsed() {
        HashMap<String,String> args = new HashMap<String,String>();
        args.put("name", "Jim");
        args.put("eyecolor", "Blue");
        String expected = "Hello";

        Templating template = new Templating(args, "Hello");
        String result = template.compile();

        assertEquals(result, expected);
    }

    public void testNoneExistantKey() {
        HashMap<String,String> args = new HashMap<String,String>();
        args.put("eyecolor", "Blue");
        String expected = "";

        Templating template = new Templating(args, "Hello ${name}, your eyes are ${${eyecolor}}");
        String result = template.compile();

        assertEquals(result, expected);
    }

    public void testRegexMatchAll() {
        HashMap<String,String> args = new HashMap<String,String>();
        String expected = "name,age,eyecolor,";
        String result = "";

        Templating template = new Templating(args, "");

        ArrayList<String> regexResult = template.regexMatchPattern("Hello ${${name}}, you are ${age} with ${eyecolor} eyes");

        for (String s : regexResult) {
            result += s+",";
        }

        assertEquals(result,expected);
    }
}