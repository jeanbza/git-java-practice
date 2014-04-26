package com.jadekler.sheri;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write some code that can be used in a templating engine. This should take a map of variables
 * ("day" => "Thursday", "name" => "Billy") as well as a string template ("${name} has an appointment 
 * on ${Thursday}") and perform substitution as needed. This needs to be somewhat robust, throwing some 
 * kind of error if a template uses a variable that has not been assigned, as well as provide a way to 
 * escape the strings ("hello ${${name}}" -> "hello ${Billy}")
 */
public class Templating {
    public static void main(String[] args) {
        
    }

    private String pattern = "\\$\\{([a-zA-Z]+)\\}";
    private HashMap<String,String> args;
    private String templateString;

    public Templating(HashMap<String,String> args, String templateString) {
        this.args = args;
        this.templateString = templateString;
    }

    public String compile() {
        ArrayList<String> matches = regexMatchPattern(this.templateString);

        for (String s : matches) {
            String keyValue = this.args.get(s);

            if (keyValue == null) {
                // We should really throw a custom exception here, but for the time being let's just 
                // simulate that behavior
                
                System.out.println("Whoops, "+s+" is not in your args!");
                return "";
            } else {
                this.templateString = this.templateString.replace("${"+s+"}", keyValue);
            }
        }

        return this.templateString;
    }

    public ArrayList<String> regexMatchPattern(String haystack) {
        ArrayList<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile(this.pattern).matcher(haystack);

        while (m.find()) {
            allMatches.add(m.group(1));
        }

        return allMatches;
    }
}