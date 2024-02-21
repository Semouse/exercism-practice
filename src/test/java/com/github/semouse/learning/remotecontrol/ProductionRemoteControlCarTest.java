package com.github.semouse.learning.remotecontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductionRemoteControlCarTest {

    @Test
    void drive() {
        RemoteControlCar car = new ProductionRemoteControlCar();
        assertEquals(0, car.getDistanceTravelled());
        car.drive();
        assertEquals(10, car.getDistanceTravelled());
    }

}