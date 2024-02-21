package com.github.semouse.learning.needforspeed;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RaceTrackTest {

    @Test
    void tryFinishTrack() {
        NeedForSpeed car = new NeedForSpeed(5, 2);
        RaceTrack raceTrack = new RaceTrack(100);

        assertTrue(raceTrack.tryFinishTrack(car));
    }
}