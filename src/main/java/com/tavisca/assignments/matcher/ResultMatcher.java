package com.tavisca.assignments.matcher;

import com.tavisca.assignments.TransformationHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultMatcher implements GetMatcher{

    @Override
    public Matcher getMatcher(String argument1, String argument2, String result) {
        double expectedOutput = Double.parseDouble(argument1)*Double.parseDouble(argument2);
        String expectedValue = TransformationHelper.getExpectedOutputInString(expectedOutput);
        Pattern argumentPattern = Pattern.compile(result.replace("?","(.?)"));
        return argumentPattern.matcher(expectedValue);
    }
}
