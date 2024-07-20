package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOfBinary(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }

        char [] x = Integer.toBinaryString(n).toCharArray();
        var sum = 0;

        for (char c : x){
            if (c == '1'){
                sum += 1;
            }
        }
        return sum;
    }
}