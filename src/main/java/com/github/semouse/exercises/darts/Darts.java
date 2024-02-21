package com.github.semouse.exercises.darts;

public class Darts {

    private static final double INNER_RING_RADIUS = 1.0;
    private static final double MIDDLE_RING_RADIUS = 5.0;
    private static final double OUTER_RING_RADIUS = 10.0;

    public int score(double xOfDart, double yOfDart) {
        double distance = Math.sqrt(Math.pow(xOfDart - 0.0, 2) + Math.pow(yOfDart - 0.0, 2));
        if (distance <= INNER_RING_RADIUS) {
            return 10;
        } else if (distance <= MIDDLE_RING_RADIUS) {
            return 5;
        } else if (distance <= OUTER_RING_RADIUS) {
            return 1;
        }

        return 0;
    }
}
