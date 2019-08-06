package com.tavisca.assignments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixMultiplication {
    public int findDigit(String equation){
        if(!equation.contains("?")){
            return -1;
        }
        else{
            String[] parameters = TransformationHelper.findArgumentsAndResultStrings(equation);
            if(parameters.length > 1){
                String argument1 = parameters[0];
                String argument2 = parameters[1];
                String result = parameters[2];
                Matcher argumentMatcher;
                argumentMatcher = getMatcher(argument1, argument2, result);

                return tryMatchingArgument(argumentMatcher);
            }
            else{
                return -1;
            }
        }
    }

    private int tryMatchingArgument(Matcher argumentMatcher) {
        if(argumentMatcher.matches()){
            try{
                return Integer.parseInt(argumentMatcher.group(1));
            }
            catch(NumberFormatException n) {
                return -1;
            }
        }
        else{
            return -1;
        }
    }

    private Matcher getMatcher(String argument1, String argument2, String result) {
        double expectedOutput;
        String expectedValue;
        Pattern argumentPattern;
        if(argument1.contains("?")){
            expectedOutput =  Double.parseDouble(result)/Double.parseDouble((argument2));
            expectedValue = getExpectedOutputInString(expectedOutput);
            argumentPattern = Pattern.compile(argument1.replace("?","(.?)"));
        }

        else if(argument2.contains("?")){
            expectedOutput = Double.parseDouble(result)/Double.parseDouble(argument1);
            expectedValue = getExpectedOutputInString(expectedOutput);
            argumentPattern = Pattern.compile(argument2.replace("?","(.?)"));
        }

        else{
            expectedOutput = Double.parseDouble(argument1)*Double.parseDouble(argument2);
            expectedValue = getExpectedOutputInString(expectedOutput);
            argumentPattern = Pattern.compile(result.replace("?","(.?)"));
        }
        return argumentPattern.matcher(expectedValue);
    }

    private String getExpectedOutputInString(double expectedOutput) {
        String expectedValue;
        if (expectedOutput == (int) expectedOutput) {
            expectedValue = "" + (int) expectedOutput;
        } else {
            expectedValue = "-1";
        }
        return expectedValue;
    }


}
