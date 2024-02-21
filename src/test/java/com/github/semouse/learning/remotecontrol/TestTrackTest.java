package com.github.semouse.learning.remotecontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class TestTrackTest {

    @Test
    void race() {
        RemoteControlCar productionCar = new ProductionRemoteControlCar();
        RemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();
        TestTrack.race(productionCar);
        TestTrack.race(productionCar);
        TestTrack.race(experimentalCar);
        TestTrack.race(experimentalCar);
        assertEquals(20,
            experimentalCar.getDistanceTravelled() - productionCar.getDistanceTravelled());
    }

    @Test
    void getRankedCars() {
        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
        prc1.setNumberOfVictories(3);
        prc2.setNumberOfVictories(2);
        List<ProductionRemoteControlCar> cars = List.of(prc2, prc1);
        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(cars);
        assertEquals(prc1, rankings.get(0));
        assertEquals(prc2, rankings.get(1));
    }
}