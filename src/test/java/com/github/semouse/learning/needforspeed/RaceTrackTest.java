package com.github.semouse.learning.needforspeed;

import static org.junit.jupiter.api.Assertions.*;

import com.github.semouse.learning.needforspeed.NeedForSpeed;
import com.github.semouse.learning.needforspeed.RaceTrack;
import org.junit.jupiter.api.Test;

class RaceTrackTest {

    @Test
    void tryFinishTrack() {
        NeedForSpeed car = new NeedForSpeed(5, 2);
        RaceTrack raceTrack = new RaceTrack(100);

        assertTrue(raceTrack.tryFinishTrack(car));
    }
}