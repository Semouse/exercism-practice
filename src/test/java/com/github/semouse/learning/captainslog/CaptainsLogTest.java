package com.github.semouse.learning.captainslog;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class CaptainsLogTest {

    private final CaptainsLog captainsLog = new CaptainsLog(new Random());

    @Test
    void randomPlanetClass() {
        char planet = captainsLog.randomPlanetClass();
        assertTrue(contains(planet));
    }

    private boolean contains(char target) {
        return IntStream.range(0, CaptainsLog.PLANET_CLASSES.length)
            .anyMatch(i -> target == CaptainsLog.PLANET_CLASSES[i]);
    }

    @Test
    void randomShipRegistryNumber() {
        String number = captainsLog.randomShipRegistryNumber();
        assertEquals(8, number.length());
    }

    @Test
    void randomStardate() {
        double date = captainsLog.randomStardate();
        assertTrue(date >= 41000.0 && date < 42000);
    }
}