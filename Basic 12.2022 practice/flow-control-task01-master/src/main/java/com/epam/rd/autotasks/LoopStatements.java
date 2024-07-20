package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOddDigits(int n) {
        //TODO: Delete line below and write your own solution

        if (n <= 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }

        char[] digits = Integer.toString(n).toCharArray();

        int number = 0;

        for (int i = digits.length-1; i>=0; i--){
            if (Character.getNumericValue(digits[i]) % 2 != 0){
                number += Character.getNumericValue(digits[i]);
            }
        }

        return number;
    }




}