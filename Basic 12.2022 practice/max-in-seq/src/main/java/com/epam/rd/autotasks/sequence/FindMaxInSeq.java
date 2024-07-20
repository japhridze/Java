package com.epam.rd.autotasks.sequence;

import java.util.Scanner;
public class FindMaxInSeq {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int maxValue = max(scanner);
        System.out.println(maxValue);

    }
    public static int max(Scanner scanner){
        int max = Integer.MIN_VALUE;
        int value;

        while (true){
            value = scanner.nextInt();
            if (value ==0){
                break;
            }
            if (value > max){
                max = value;
            }
        }
        return max;
    }
}