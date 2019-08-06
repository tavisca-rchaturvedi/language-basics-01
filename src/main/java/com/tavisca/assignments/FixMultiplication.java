package com.tavisca.assignments;

import com.tavisca.assignments.matcher.ArgumentMatcher;
import com.tavisca.assignments.matcher.ResultMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixMultiplication {
    public int findDigit(String equation){
        Matcher validEquationMatcher = Pattern.compile("(.*)(\\?)(.*)").matcher(equation);

        if(!validEquationMatcher.matches()){
            return -1;
        }
        else{
            String[] parameters = TransformationHelper.findArgumentsAndResultStrings(equation);
            if(parameters.length > 1){
                String argument1 = parameters[0];
                String argument2 = parameters[1];
                String result = parameters[2];
                Matcher argumentMatcher;
                argumentMatcher = getPattern(argument1, argument2, result);

                return TransformationHelper.tryMatchingArgument(argumentMatcher);
            }
            else{
                return -1;
            }
        }
    }

    public Matcher getPattern(String argument1, String argument2, String result) {
        double expectedOutput;
        Matcher matcher;
        if(argument1.contains("?")){
            matcher = (new ArgumentMatcher()).getMatcher(argument1,argument2,result);
        }

        else if(argument2.contains("?")){
            matcher = (new ArgumentMatcher()).getMatcher(argument2,argument1,result);
        }

        else{
            matcher = (new ResultMatcher()).getMatcher(argument1,argument2,result);
        }
        return matcher;
    }




}
