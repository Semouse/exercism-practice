package com.github.semouse.learning.needforspeed;

public class NeedForSpeed {

    private final int speed;
    private final int batteryDrain;
    private int battery;
    private int distanceDriven;

    public int getBattery() {
        return battery;
    }

    public int getDistanceDriven() {
        return distanceDriven;
    }

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.battery = 100;
        this.distanceDriven = 0;
    }

    public boolean batteryDrained() {
        return battery <= 0;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if (!batteryDrained()) {
            this.distanceDriven += speed;
            this.battery -= batteryDrain;
        }
    }

    /**
     * The best-selling remote control car is the Nitro, which has a stunning top speed of 50 meters
     * with a battery drain of 4%.
     *
     * @return nitro car
     */
    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}
