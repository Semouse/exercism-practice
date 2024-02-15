package com.github.semouse.elonstoycar;

/**
 * Instructions: In this exercise you'll be playing around with a remote controlled car, which
 * you've finally saved enough money for to buy.
 * <p>
 * Cars start with full (100%) batteries. Each time you drive the car using the remote control, it
 * covers 20 meters and drains one percent of the battery.
 * <p>
 * The remote controlled car has a fancy LED display that shows two bits of information:
 * <p>
 * The total distance it has driven, displayed as: "Driven <METERS> meters".
 * <p>
 * The remaining battery charge, displayed as: "Battery at <PERCENTAGE>%".
 * <p>
 * If the battery is at 0%, you can't drive the car anymore and the battery display will show
 * "Battery empty".
 */
public class ElonsToyCar {

    private int distance;
    private int battery;

    public ElonsToyCar() {
        this.distance = 0;
        this.battery = 100;
    }

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", distance);
    }

    public String batteryDisplay() {
        return battery == 0 ? "Battery empty" : String.format("Battery at %d%%", battery);
    }

    public void drive() {
        if (battery > 0) {
            this.distance += 20;
            this.battery -= 1;
        }
    }
}
