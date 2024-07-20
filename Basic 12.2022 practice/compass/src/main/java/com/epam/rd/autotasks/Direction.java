package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        degrees %= 360;
        if (degrees < 0) {
            degrees += 360;
        }

        for (Direction direction : Direction.values()) {
            if (direction.degrees == degrees) {
                return direction;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees %= 360;
        if (degrees < 0) {
            degrees += 360;
        }

        Direction closestDirection = null;
        int minDifference = Integer.MAX_VALUE;

        for (Direction direction : Direction.values()) {
            int difference = Math.abs(direction.degrees - degrees);
            if (difference < minDifference) {
                minDifference = difference;
                closestDirection = direction;
            }
        }

        return closestDirection;
    }

    public Direction opposite() {
        int oppositeDegrees = (this.degrees + 180) % 360;
        return ofDegrees(oppositeDegrees);
    }

    public Integer differenceDegreesTo(Direction direction) {
        if (direction == null) {
            return null;
        }
        int difference = direction.degrees - this.degrees;
        if (difference < 0) {
            difference += 360;
        }
        if (difference > 180) {
            difference = 360 - difference;
        }
        return difference;
    }

}