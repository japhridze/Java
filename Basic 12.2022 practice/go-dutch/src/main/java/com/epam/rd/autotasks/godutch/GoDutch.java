package com.epam.rd.autotasks.godutch;


import java.util.Scanner;

public class GoDutch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int billAmount = scanner.nextInt();

        if (billAmount < 0) {
            System.out.println("Bill total amount cannot be negative");
            return;

        }

        int numberOfFriends = scanner.nextInt();
        if (numberOfFriends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
            return;

        }
        scanner.close();
        int totalPayment = billAmount + (billAmount * 10 / 100);

        int partToPay = totalPayment / numberOfFriends;

        System.out.println(partToPay);


    }
}


