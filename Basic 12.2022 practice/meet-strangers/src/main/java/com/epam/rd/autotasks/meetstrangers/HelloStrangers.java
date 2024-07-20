package com.epam.rd.autotasks.meetstrangers;

import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int strangerCount = scanner.nextInt();
        scanner.nextLine();
        if (strangerCount == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if (strangerCount < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {
            String[] strangers = new String[strangerCount];
            for (int i = 0; i < strangerCount; i++) {
                strangers[i] = scanner.nextLine();
            }
            for (String stranger : strangers) {
                System.out.println("Hello, " + stranger);
            }
        }
        scanner.close();
    }
}


