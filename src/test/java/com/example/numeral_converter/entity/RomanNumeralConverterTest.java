package com.example.numeral_converter.entity;

import com.example.numeral_converter.external.RomanNumeralConverterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConverterTest {

    @Test
    public void testIntToRoman1(){
        assertEquals(RomanNumeralConverter.intToRoman(99), "XCIX");
    }


    @Test
    public void testIntToRoman4(){
        assertEquals(RomanNumeralConverter.intToRoman(708), "DCCVIII");
    }

    @Test
    public void testIntToRoman2(){
        assertEquals(RomanNumeralConverter.intToRoman(3999), "MMMCMXCIX");
    }

    @Test
    public void testIntToRoman3(){
        assertEquals(RomanNumeralConverter.intToRoman(1020), "MXX");
    }

    @Test
    public void testIntToRoman5(){
        assertThrows(RomanNumeralConverterException.class, () -> {RomanNumeralConverter.intToRoman(4000);} );
    }

    @Test
    public void testIntToRoman6(){
        assertThrows(RomanNumeralConverterException.class, () -> {RomanNumeralConverter.intToRoman(0);} );
    }

    @Test
    public void testNumToRoman1(){
        assertEquals(RomanNumeralConverter.numToRoman("3999"), "MMMCMXCIX");
    }

    @Test
    public void testNumToRoman2(){
        assertEquals(RomanNumeralConverter.numToRoman("400"), "CD");
    }

}