package com.epam.rd.autotasks.triangle;
public class Triangle {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        if (!isValidTriangle(point1, point2, point3)) {
            throw new IllegalArgumentException();
        }

        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    private boolean isValidTriangle(Point point1, Point point2, Point point3) {
        double area = 0.5 * ((point2.getX() - point1.getX()) * (point3.getY() - point1.getY()) -
                (point3.getX() - point1.getX()) * (point2.getY() - point1.getY()));

        return area != 0;
    }

    public double area() {
        return 0.5 * Math.abs((point1.getX() - point3.getX()) * (point2.getY() - point3.getY()) -
                (point2.getX() - point3.getX()) * (point1.getY() - point3.getY()));
    }

    public Point centroid() {
        double centroidX = (point1.getX() + point2.getX() + point3.getX()) / 3.0;
        double centroidY = (point1.getY() + point2.getY() + point3.getY()) / 3.0;
        return new Point(centroidX, centroidY);
    }


}

