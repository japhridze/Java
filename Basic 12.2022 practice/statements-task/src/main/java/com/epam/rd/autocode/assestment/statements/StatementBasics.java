package com.epam.rd.autocode.assestment.statements;

public class StatementBasics {
    public static int addPositive(int value) {
        if (value > 0) {
            return value + 1;
        } else {
            return value;
        }
    }

    public static int addPositiveSubtractNegative(int value) {
        if (value > 0) {
            return value + 1;
        } else {
            return value - 2;
        }
    }

    public static int addPositiveSubtractNegativeReplaceZero(int value) {
        if (value > 0) {
            return value + 1;
        } else if (value < 0) {
            return value - 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(addPositive(5));
        System.out.println(addPositive(-5));
        System.out.println(addPositive(0));
        System.out.println(addPositiveSubtractNegative(5));
        System.out.println(addPositiveSubtractNegative(-5));
        System.out.println(addPositiveSubtractNegative(0));
        System.out.println(addPositiveSubtractNegativeReplaceZero(5));
        System.out.println(addPositiveSubtractNegativeReplaceZero(-5));
        System.out.println(addPositiveSubtractNegativeReplaceZero(0));
    }
}
