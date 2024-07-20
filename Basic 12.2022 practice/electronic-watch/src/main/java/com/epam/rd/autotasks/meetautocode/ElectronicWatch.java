package com.epam.rd.autotasks.meetautocode;


import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int hours = input / 3600 % 24;
        int minutes = input % 3600 / 60;
        int seconds = input % 60;

        String formattedTime = String.format("%d:%02d:%02d", hours, minutes, seconds);
        System.out.println(formattedTime);
    }
}


