package com.epam.rd.qa.classes;

import java.util.Arrays;

public class ArrayRectangles {
    private Rectangle[] rectangleArray;

    public ArrayRectangles(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be a positive integer.");
        }
        rectangleArray = new Rectangle[size];
    }

    public ArrayRectangles(Rectangle... rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            throw new IllegalArgumentException("Array of rectangles must not be null or empty.");
        }
        rectangleArray = Arrays.copyOf(rectangles, rectangles.length);
    }

    public boolean addRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i] == null) {
                rectangleArray[i] = rectangle;
                return true;
            }
        }
        return false;
    }

    public int size() {
        int count = 0;
        for (Rectangle rectangle : rectangleArray) {
            if (rectangle != null) {
                count++;
            }
        }
        return count;
    }

    public int indexMaxArea() {
        double maxArea = Double.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i] != null && rectangleArray[i].area() > maxArea) {
                maxArea = rectangleArray[i].area();
                index = i;
            }
        }
        return index;
    }

    public int indexMinPerimeter() {
        double minPerimeter = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i] != null && rectangleArray[i].perimeter() < minPerimeter) {
                minPerimeter = rectangleArray[i].perimeter();
                index = i;
            }
        }
        return index;
    }

    public int numberSquares() {
        int count = 0;
        for (Rectangle rectangle : rectangleArray) {
            if (rectangle != null && rectangle.isSquare()) {
                count++;
            }
        }
        return count;
    }
}
