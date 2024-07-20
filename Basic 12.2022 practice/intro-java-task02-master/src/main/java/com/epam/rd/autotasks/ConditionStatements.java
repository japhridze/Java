package com.epam.rd.autotasks;


public class ConditionStatements {
    public static int task2(int n) {

        int digit1 = n / 100;
        int digit2 = (n / 10) % 10;
        int digit3 = n % 10;


        int maxNumber = Math.max(digit1, Math.max(digit2, digit3)) * 100; //aseulebis
        int middleNumber = (digit1 + digit2 + digit3 - Math.max(digit1, Math.max(digit2, digit3)) - Math.min(digit1, Math.min(digit2, digit3))) * 10;//ateulebis
        int minNumber = Math.min(digit1, Math.min(digit2, digit3));//erteulebi


        return maxNumber + middleNumber + minNumber;
    }

    public static void main(String[] args) {

        System.out.println(task2(165));
        System.out.println(task2(321));
    }
}
