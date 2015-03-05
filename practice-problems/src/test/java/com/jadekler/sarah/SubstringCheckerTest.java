package com.jadekler.sarah;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SubstringCheckerTest {
    private SubstringChecker checker = new SubstringChecker();

    @Test
    public void testSort() {
        String source = "abbaabbababbbbbbaaabbaaaababbbaaababaaa";
        String target = "baaaabab";

        assertTrue(checker.isSubstring(source, target));
    }
}