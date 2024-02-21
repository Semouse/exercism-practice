package com.github.semouse.learning.needforspeed;

public class RaceTrack {

    private final int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        while (!car.batteryDrained()) {
            car.drive();
        }

        return car.distanceDriven() >= distance;
    }

}
