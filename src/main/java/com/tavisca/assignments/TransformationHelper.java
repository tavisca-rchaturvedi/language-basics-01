package com.tavisca.assignments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformationHelper {

    public static String[] findArgumentsAndResultStrings(String equation) {
        Pattern equationPattern = Pattern.compile("(.*)\\*(.*)=(.*)");
        Matcher equationMatcher = equationPattern.matcher(equation);
        String argument1 = "", argument2 = "", result = "";

        if(equationMatcher.matches()){
            argument1 = equationMatcher.group(1);
            argument2 = equationMatcher.group(2);
            result = equationMatcher.group(3);

            return new String[]{argument1, argument2, result};
        }
        else{
            return new String[]{};
        }
    }
}