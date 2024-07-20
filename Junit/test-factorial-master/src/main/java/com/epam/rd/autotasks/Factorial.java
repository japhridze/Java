package com.epam.rd.autotasks;

public class Factorial {
    public String factorial(String n) {
        if (n == null) {
            throw new IllegalArgumentException();
        }

        int number;
        try {
            number = Integer.parseInt(n);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (number < 0) {
            throw new IllegalArgumentException();
        }

        return String.valueOf(calculateFactorial(number));
    }

    private long calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }
}
