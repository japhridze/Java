package com.epam.rd.autotasks.triangle;

public class Main {
    public static void main(String[] args) {
        try {

            new Triangle(new Point(0, 0), new Point(1, 0), new Point(2, 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        double area = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)).area();
        System.out.println(area);


        Point centroid = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 3)).centroid();
        System.out.println(centroid.getX());
        System.out.println(centroid.getY());
    }
}
