package com.epam.rd.qa.basicio;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        mulMain(args);
    }

    static void mulMain(String[] args) {
        Random r = new Random(10);
        Matrix m1 = randomInit(r, 5, 5);
        Matrix m2 = randomInit(r, 5, 5);
        r = new Random(15);
        Matrix m3 = randomInit(r, 2, 3);
        Matrix m4 = randomInit(r, 3, 2);
        r = new Random(2);
        Matrix m5 = randomInit(r, 3, 1);
        Matrix m6 = randomInit(r, 1, 3);
        System.out.printf("Seed 10 - m1.multiply(m2) %s%n", m1.multiply(m2));
        System.out.printf("Seed 10 - m2.multiply(m1) %s%n", m2.multiply(m1));
        System.out.printf("Seed 15 - m3.multiply(m4) %s%n", m3.multiply(m4));
        System.out.printf("Seed 15 - m4.multiply(m3) %s%n", m4.multiply(m3));
        System.out.printf("Seed  2 - m5.multiply(m6) %s%n", m5.multiply(m6));
        System.out.printf("Seed  2 - m6.multiply(m5) %s%n", m6.multiply(m5));
    }

    static void subMain(String[] args) {
        Random r = new Random(10);
        Matrix m1 = randomInit(r, 5, 5);
        Matrix m2 = randomInit(r, 5, 5);
        r = new Random(15);
        Matrix m3 = randomInit(r, 1, 3);
        Matrix m4 = randomInit(r, 1, 3);
        r = new Random(2);
        Matrix m5 = randomInit(r, 3, 1);
        Matrix m6 = randomInit(r, 3, 1);
        System.out.printf("Seed 10 - m1.subtract(m2) %s%n", m1.subtract(m2));
        System.out.printf("Seed 10 - m2.subtract(m1) %s%n", m2.subtract(m1));
        System.out.printf("Seed 10 - m1.subtract(m1) %s%n", m1.subtract(m1));
        System.out.printf("Seed 15 - m3.subtract(m4) %s%n", m3.subtract(m4));
        System.out.printf("Seed 15 - m4.subtract(m3) %s%n", m4.subtract(m3));
        System.out.printf("Seed 15 - m4.subtract(m4) %s%n", m3.subtract(m3));
        System.out.printf("Seed  2 - m5.subtract(m6) %s%n", m5.subtract(m6));
        System.out.printf("Seed  2 - m6.subtract(m5) %s%n", m6.subtract(m5));
        System.out.printf("Seed  2 - m6.subtract(m6) %s%n", m6.subtract(m6));
    }

    static void addMain(String[] args) {
        Random r = new Random(10);
        Matrix m1 = randomInit(r, 5, 5);
        Matrix m2 = randomInit(r, 5, 5);
        r = new Random(15);
        Matrix m3 = randomInit(r, 1, 3);
        Matrix m4 = randomInit(r, 1, 3);
        r = new Random(2);
        Matrix m5 = randomInit(r, 3, 1);
        Matrix m6 = randomInit(r, 3, 1);
        System.out.printf("Seed 10 - m1.add(m2) %s%n", m1.add(m2));
        System.out.printf("Seed 10 - m1.add(m1) %s%n", m1.add(m1));
        System.out.printf("Seed 10 - m2.add(m2) %s%n", m2.add(m2));
        System.out.printf("Seed 15 - m3.add(m4) %s%n", m3.add(m4));
        System.out.printf("Seed 15 - m3.add(m3) %s%n", m3.add(m3));
        System.out.printf("Seed 15 - m4.add(m4) %s%n", m4.add(m4));
        System.out.printf("Seed  2 - m5.add(m6) %s%n", m5.add(m6));
        System.out.printf("Seed  2 - m5.add(m5) %s%n", m5.add(m5));
        System.out.printf("Seed  2 - m6.add(m6) %s%n", m6.add(m6));
    }

    static Matrix randomInit(Random r,  int rows, int cols) {
        double[][] doubles = new double[rows][];
        for (int i = 0; i < rows; i++) {
            doubles[i] = r.doubles(cols, -25., 25.).toArray();
        }
        return new Matrix(doubles);
    }

}
