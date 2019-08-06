package com.tavisca.assignments;

import org.junit.Test;
import static org.junit.Assert.*;

public class FixMultiplicationTest {
    @Test
    public void isFindDigitWorkingOnTestCase1(){
        String equation = "42*47=1?74";
        int output = 9;
        FixMultiplication fixMultiplication = new FixMultiplication();
        assertEquals(output, fixMultiplication.findDigit(equation));

    }

    @Test
    public void isFindDigitWorkingOnTestCase2(){
        String equation = "4?*47=1974";
        int output = 2;
        FixMultiplication fixMultiplication = new FixMultiplication();
        assertEquals(output, fixMultiplication.findDigit(equation));

    }

    @Test
    public void isFindDigitWorkingOnTestCase3(){
        String equation = "42*?7=1974";
        int output = 4;
        FixMultiplication fixMultiplication = new FixMultiplication();
        assertEquals(output, fixMultiplication.findDigit(equation));

    }

    @Test
    public void isFindDigitWorkingOnTestCase4(){
        String equation = "42*47=1974";
        int output = -1;
        FixMultiplication fixMultiplication = new FixMultiplication();
        assertEquals(output, fixMultiplication.findDigit(equation));

    }

    @Test
    public void isFindDigitWorkingOnTestCase5(){
        String equation = "2*12?=247";
        int output = -1;
        FixMultiplication fixMultiplication = new FixMultiplication();
        assertEquals(output, fixMultiplication.findDigit(equation));

    }

    @Test
    public void isFindArgumentsAndResultStringsTest(){
        String equation = "42*47=1?74";
        String[] parameters = new String[]{"42","47","1?74"};
        FixMultiplication fixMultiplication = new FixMultiplication();
        assertArrayEquals(parameters, fixMultiplication.findArgumentsAndResultStrings(equation));
    }
}
