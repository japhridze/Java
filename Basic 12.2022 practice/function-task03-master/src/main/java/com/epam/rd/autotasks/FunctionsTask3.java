package com.epam.rd.autotasks;

public class FunctionsTask3 {
    public static int multiArithmeticElements(int a1, int t, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Number of elements (n) must be greater than 0.");
        }

        long result = 1; // Start with a long to handle intermediate multiplication safely.
        for (int i = 0; i < n; i++) {
            result *= (a1 + (long)i * t);
        }

        // Ensure the final result fits within an int, as per test cases.
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("Result exceeds the bounds of int.");
        }

        return (int) result; // Cast is safe because we're within int bounds.
    }
}
