package com.github.semouse.exercises.spaceage;

class SpaceAge {

    private static final double YEAR_IN_SECOND = 31_557_600.0;
    private final double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double onEarth() {
        return seconds / YEAR_IN_SECOND;
    }

    double onMercury() {
        return onEarth() / 0.2408467;
    }

    double onVenus() {
        return onEarth() / 0.61519726;
    }

    double onMars() {
        return onEarth() / 1.8808158;
    }

    double onJupiter() {
        return onEarth() / 11.862615;
    }

    double onSaturn() {
        return onEarth() / 29.447498;
    }

    double onUranus() {
        return onEarth() / 84.016846;
    }

    double onNeptune() {
        return onEarth() / 164.79132;
    }

}
