package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;

class Segment {

    private Point start;
    private  Point end;

    public Segment(Point start, Point end) {

        if (start.getX() == end.getX() && end.getY() == end.getY()){
            throw new IllegalArgumentException();
        }

        this.start = start;
        this.end = end;
    }

    public double length() {

        return Math.sqrt((end.getX()-start.getX()) * (end.getX()-start.getX()) + (end.getY()-start.getY()));
    }

    public Point middle() {
        double middleX = (start.getX() + end.getX()) / 2;
        double middleY = (start.getY() + end.getY()) / 2;
        return new Point(middleX, middleY);
    }

    Point intersection(Segment another) {

        double x1 = start.getX(), y1 = start.getY();
        double x2 = end.getX(), y2 = end.getY();
        double x3 = another.start.getX(), y3 = another.start.getY();
        double x4 = another.end.getX(), y4 = another.end.getY();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        if (denominator == 0) {
            // Segments are parallel or collinear
            return null;
        }
        double intersectionX = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;
        double intersectionY = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;

        if (isBetween(intersectionX, x1, x2) && isBetween(intersectionY, y1, y2)
                && isBetween(intersectionX, x3, x4) && isBetween(intersectionY, y3, y4)) {
            return new Point(intersectionX, intersectionY);
        }

         return null;
    }
    private boolean isBetween(double value, double start, double end) {
        return value >= Math.min(start, end) && value <= Math.max(start, end);
    }

}
