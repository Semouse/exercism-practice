package com.github.semouse.remotecontrol;

public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distance;

    /**
     * ExperimentalRemoteControlCar drives 20 units.
     */
    @Override
    public void drive() {
        this.distance += 20;
    }

    @Override
    public int getDistanceTravelled() {
        return distance;
    }
}
