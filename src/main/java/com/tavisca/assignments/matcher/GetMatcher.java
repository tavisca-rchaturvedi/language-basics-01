package com.tavisca.assignments.matcher;

import java.util.regex.Matcher;

public interface GetMatcher {
    public Matcher getMatcher(String argument1, String argument2, String result);
}
