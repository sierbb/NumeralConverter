package com.example.numeral_converter.entity;

import com.example.numeral_converter.external.RomanNumeralConverterException;

import java.util.Map;
import java.util.HashMap;

public class RomanNumeralConverter {

    public static Map<Integer, String> zero = new HashMap<>();
    public static Map<Integer, String> ten = new HashMap<>();
    public static Map<Integer, String> hundred = new HashMap<>();

    static {
        zero.put(4, "IV");
        zero.put(9, "IX");
        zero.put(1, "I");
        zero.put(2, "II");
        zero.put(3, "III");
        zero.put(5, "V");
        zero.put(6, "VI");
        zero.put(7, "VII");
        zero.put(8, "VIII");

        ten.put(4, "XL");
        ten.put(9, "XC");
        ten.put(1, "X");
        ten.put(2, "XX");
        ten.put(3, "XXX");
        ten.put(5, "L");
        ten.put(6, "LX");
        ten.put(7, "LXX");
        ten.put(8, "LXXX");

        hundred.put(4, "CD");
        hundred.put(9, "CM");
        hundred.put(1, "C");
        hundred.put(2, "CC");
        hundred.put(3, "CCC");
        hundred.put(5, "D");
        hundred.put(6, "DC");
        hundred.put(7, "DCC");
        hundred.put(8, "DCCC");
    }

    public RomanNumeralConverter(){}

    public static String intToRoman(Integer num) {


        if (num <= 0 || num > 3999){
            throw new RomanNumeralConverterException("Input out or range, should be between 1 and 3999");
        }
        StringBuilder sb = new StringBuilder();

        //Processing digits at thousand level - "3000" -> 3
        int thousandDigit = num / 1000;
        num = num % 1000;
        for (int i=0; i < thousandDigit; i++){
            sb.append("M");
        }

        //Processing digits at hundred level - "300" -> 3
        int hundredDigit = num / 100; // 9
        num = num % 100;
        sb.append(hundredDigit == 0? "" : hundred.get(hundredDigit));

        //Processing digits at ten level - "30" -> 3
        int tenDigit = num / 10;
        num = num % 10;
        sb.append(tenDigit == 0? "" : ten.get(tenDigit));

        //Processing digits at single level - "3" -> 3
        int singleDigit = num;
        sb.append(singleDigit == 0? "" : zero.get(singleDigit));

        return sb.toString();
    }

    public static String numToRoman(String strNum){
        try {
            Integer num = Integer.parseInt(strNum);
            return intToRoman(Integer.valueOf(num));
        } catch (NumberFormatException e) {
            throw new RomanNumeralConverterException(e.getMessage());
        }
    }
}
