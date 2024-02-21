package com.github.semouse.learning.elonstoycar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.semouse.learning.elonstoycar.ElonsToyCar;
import org.junit.jupiter.api.Test;

class ElonsToyCarTest {

    @Test
    void distanceDisplay() {
        ElonsToyCar car = ElonsToyCar.buy();
        assertEquals("Driven 0 meters", car.distanceDisplay());
    }

    @Test
    void batteryDisplay() {
        ElonsToyCar car = ElonsToyCar.buy();
        assertEquals("Battery at 100%", car.batteryDisplay());
    }

    @Test
    void drive() {
        ElonsToyCar car = ElonsToyCar.buy();
        car.drive();
        String distance = car.distanceDisplay();
        String battery = car.batteryDisplay();
        assertEquals("Battery at 99%", battery);
        assertEquals("Driven 20 meters", distance);
    }

    @Test
    void notDriveIfBatteryEmpty() {
        ElonsToyCar car = ElonsToyCar.buy();
        for(int i = 0; i < 101; i++){
            car.drive();
        }

        String distance = car.distanceDisplay();
        String battery = car.batteryDisplay();
        assertEquals("Battery empty", battery);
        assertEquals("Driven 2000 meters", distance);
    }
}