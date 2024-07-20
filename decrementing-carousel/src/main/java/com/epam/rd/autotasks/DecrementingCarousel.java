package com.epam.rd.autotasks;


import java.util.ArrayList;

import java.util.List;

class DecrementingCarousel {
    private final int capacity;
    private final List<Integer> elements;
    private boolean isRunning;
    private boolean runMethodCalled;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.elements = new ArrayList<>();
        this.isRunning = false;
        this.runMethodCalled = false;
    }

    public boolean addElement(int element) {
        if (element <= 0 || elements.size() >= capacity || isRunning || runMethodCalled) {
            return false;
        }

        elements.add(element);
        return true;
    }

    public CarouselRun run() { 
        if (runMethodCalled) {
            return null;
        }

        runMethodCalled = true;
        isRunning = true;
        return new CarouselRun(elements.iterator());
    }


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

