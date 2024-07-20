package com.epam.rd.autotasks;

public class Main {
    public static void main(String[] args) {

        DecrementingCarousel carousel = new DecrementingCarousel(10);

        System.out.println(carousel.addElement(2));
        System.out.println(carousel.addElement(3));
        System.out.println(carousel.addElement(1));

        carousel.run();

        System.out.println(carousel.addElement(2));
        System.out.println(carousel.addElement(3));
        System.out.println(carousel.addElement(1));
    }
}