package com.epam.rd.qa.classes;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double a, double b) {
        this.sideA = a;
        this.sideB = b;
    }

    public Rectangle(double side) {
        this(side, side);
    }

    public Rectangle() {
        this(4, 3);
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area() {
        return sideA * sideB;
    }

    public double perimeter() {
        return 2 * (sideA + sideB);
    }

    public boolean isSquare() {
        return sideA == sideB;
    }

    public void replaceSides() {
        double temp = sideA;
        sideA = sideB;
        sideB = temp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle other = (Rectangle) obj;
        return Double.compare(other.sideA, sideA) == 0 && Double.compare(other.sideB, sideB) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(sideA);
        result = 31 * result + Double.hashCode(sideB);
        return result;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }
}
