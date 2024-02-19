package com.github.semouse.captainslog;

import java.util.Random;

public class CaptainsLog {

    static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R',
        'T', 'Y'};
    private final Random random;

    public CaptainsLog(Random random) {
        this.random = random;
    }

    public char randomPlanetClass() {
        return PLANET_CLASSES[random.nextInt(PLANET_CLASSES.length)];
    }

    public String randomShipRegistryNumber() {
        return String.format("NCC-%d", 1000 + random.nextInt(9000));
    }

    public double randomStardate() {
        return 41000 + 1000 * random.nextDouble();
    }
}
