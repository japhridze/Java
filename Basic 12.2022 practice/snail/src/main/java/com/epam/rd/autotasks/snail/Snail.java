package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();
        scanner.close();

        int days = 0;
        int climbed = 0;

        while (climbed < h) {
            climbed += a;
            days++;

            if (climbed >= h) {
                break;
            }

            climbed -= b;
        }

        if (climbed >= h) {
            System.out.println(days);
        } else {
            System.out.println("Impossible");
        }
    }
}
