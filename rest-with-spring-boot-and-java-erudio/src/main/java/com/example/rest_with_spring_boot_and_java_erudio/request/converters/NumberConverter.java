package com.example.rest_with_spring_boot_and_java_erudio.request.converters;

public class NumberConverter {
    public static Double converToDouble(String number1) {
        if (number1 == null || number1.isEmpty()) throw new UnsupportedOperationException ("Please provide a number");
        String number = number1.replace(",",".");
        number.matches("[-+]?[0-9]*\\.?[0-9]+");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) throw new UnsupportedOperationException ("Please provide a numeric value");
        String number = str.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
    public static boolean isPossibleToSqrt(Double number) {
        if (number == null) throw new IllegalArgumentException ("Please provide a numeric value");
        if (number < 0) throw new IllegalArgumentException ("Please provide a positive number");
        return true;
    }


    public static boolean isNotPossibleToDivide(Double number) {
        return number == 0;
    }
}
