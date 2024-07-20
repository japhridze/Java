package com.epam.rd.autotasks.max;
public class MaxMethod {
    public static int max(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null.");

        }
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] numbers = {-2, 0, 10, 5};
        int result = max(numbers);
        System.out.println(result == 10);
    }
}
