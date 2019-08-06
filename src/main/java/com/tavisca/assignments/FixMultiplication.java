package com.tavisca.assignments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixMultiplication {
    public int findDigit(String equation){
        if(!equation.contains("?")){
            return -1;
        }
        else{
            String[] parameters = findArgumentsAndResultStrings(equation);
            if(parameters.length > 1){
                String argument1 = parameters[0];
                String argument2 = parameters[1];
                String result = parameters[2];

                Pattern argumentPattern;
                Matcher argumentMatcher;
                String expectedValue;
                double expectedOutput;

                if(argument1.contains("?")){
                    expectedOutput =  Double.parseDouble(result)/Double.parseDouble((argument2));
                    if(expectedOutput == (int)expectedOutput){
                        expectedValue = "" + (int)expectedOutput;
                    }
                    else{
                        expectedValue = "-1";
                    }
                    argumentPattern = Pattern.compile(argument1.replace("?","(.?)"));
                    argumentMatcher = argumentPattern.matcher(expectedValue);
                }

                else if(argument2.contains("?")){
                    expectedOutput = Double.parseDouble(result)/Double.parseDouble(argument1);
                    if(expectedOutput == (int)expectedOutput){
                        expectedValue = "" + (int)expectedOutput;
                    }
                    else{
                        expectedValue = "-1";
                    }
                    argumentPattern = Pattern.compile(argument2.replace("?","(.?)"));
                    argumentMatcher = argumentPattern.matcher(expectedValue);
                }

                else{
                    expectedOutput = Double.parseDouble(argument1)*Double.parseDouble(argument2);
                    if(expectedOutput == (int)expectedOutput){
                        expectedValue = "" + (int)expectedOutput;
                    }
                    else{
                        expectedValue = "-1";
                    }
                    argumentPattern = Pattern.compile(result.replace("?","(.?)"));
                    argumentMatcher = argumentPattern.matcher(expectedValue);
                }

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
            else{
                return -1;
            }
        }
    }

    public String[] findArgumentsAndResultStrings(String equation) {
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
