package com.github.semouse.carassemble;

public class CarsAssemble {

    private static final int BASIC_PRODUCTION_PER_HOUR = 221;

    public double productionRatePerHour(int speed) {
        return BASIC_PRODUCTION_PER_HOUR * speed * successRate(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }

    private double successRate(int speed) {
        return switch (speed) {
            case 1, 2, 3, 4 -> 1.0;
            case 5, 6, 7, 8 -> 0.9;
            case 9 -> 0.8;
            case 10 -> 0.77;
            default -> 0.0;
        };
    }
}
