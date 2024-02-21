package com.github.semouse.learning.remotecontrol;

import static org.junit.jupiter.api.Assertions.*;

import com.github.semouse.learning.remotecontrol.ExperimentalRemoteControlCar;
import com.github.semouse.learning.remotecontrol.RemoteControlCar;
import org.junit.jupiter.api.Test;

class ExperimentalRemoteControlCarTest {

    @Test
    void drive() {
        RemoteControlCar car = new ExperimentalRemoteControlCar();
        assertEquals(0, car.getDistanceTravelled());
        car.drive();
        assertEquals(20, car.getDistanceTravelled());
    }
}