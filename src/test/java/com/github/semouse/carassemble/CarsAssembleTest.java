package com.github.semouse.carassemble;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarsAssembleTest {

    @Test
    void productionRatePerHour() {
        CarsAssemble carsAssemble = new CarsAssemble();
        double result = carsAssemble.productionRatePerHour(6);
        assertEquals(1193.4, result);
    }

    @Test
    void workingItemsPerMinute() {
        CarsAssemble carsAssemble = new CarsAssemble();
        int result = carsAssemble.workingItemsPerMinute(6);
        assertEquals(19, result);
    }
}