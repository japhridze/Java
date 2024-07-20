package com.epam.rd.autotasks;


import java.util.Iterator;

public class CarouselRun {
    private final Iterator<Integer> iterator;
    private int current;

    public CarouselRun(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.current = -1;
        moveToNext();
    }

    private void moveToNext() {
        while (iterator.hasNext() && current <= 0) {
            current = iterator.next();
        }
    }

    public int next() {
        if (current <= 0) {
            moveToNext();
        }

        if (current <= 0) {
            return -1;
        }

        int currentValue = current;
        current--;
        return currentValue;
    }

    public boolean isFinished() {
        return current <= 0 && !iterator.hasNext();
    }
}
