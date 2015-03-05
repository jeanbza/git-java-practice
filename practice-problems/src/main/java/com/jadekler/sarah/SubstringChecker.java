package com.jadekler.sarah;

public class SubstringChecker {
    public boolean isSubstring(String source, String target) {
        for (int i = 0; i < source.length() - target.length(); i++) {
            if (source.substring(i, i + target.length()).equals(target)) {
                return true;
            }
        }

        return false;
    }
}
