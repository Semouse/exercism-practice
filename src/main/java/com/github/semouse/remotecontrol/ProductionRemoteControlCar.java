package com.github.semouse.remotecontrol;

import java.util.Objects;

public class ProductionRemoteControlCar implements RemoteControlCar,
    Comparable<ProductionRemoteControlCar> {

    private int distance;
    private int numberOfVictories;

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    /**
     * ProductionRemoteControlCar drives 10 units,
     */
    @Override
    public void drive() {
        distance += 10;
    }

    @Override
    public int getDistanceTravelled() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductionRemoteControlCar that = (ProductionRemoteControlCar) o;
        return distance == that.distance && numberOfVictories == that.numberOfVictories;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, numberOfVictories);
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        return Integer.compare(o.numberOfVictories, this.numberOfVictories);
    }
}
