package com.github.semouse.learning.needforspeed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class NeedForSpeedTest {

    @Test
    void batteryDrained() {
        NeedForSpeed car = new NeedForSpeed(10, 5);
        car.drive();
        assertFalse(car.batteryDrained());
    }

    @Test
    void distanceDriven() {
        NeedForSpeed car = new NeedForSpeed(15, 2);
        car.drive();
        assertEquals(15, car.distanceDriven());
    }

    @Test
    void drive() {
        NeedForSpeed car = new NeedForSpeed(15, 2);
        car.drive();
        assertEquals(15, car.getDistanceDriven());
        assertEquals(98, car.getBattery());
    }

    @Test
    void driveNotIncreaseDistanceWhenBatteryDrained() {
        int speed = 9;
        int batteryDrain = 50;
        NeedForSpeed car = new NeedForSpeed(speed, batteryDrain);
        for (int i = 0; i < 3; i++) {
            car.drive();
        }
        assertEquals(18, car.distanceDriven());
    }

    @Test
    void nitro() {
        NeedForSpeed car = NeedForSpeed.nitro();
        car.drive();
        assertEquals(50, car.distanceDriven());
    }
}