package com.github.semouse.exercises.darts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DartsTest {

    Darts darts = new Darts();

    @Test
    void missedTarget() {
        assertEquals(0, darts.score(-9, 9));
    }


    @Test
    void onTheOuterCircle() {
        assertEquals(1, darts.score(0, 10));
    }


    @Test
    void onTheMiddleCircle() {
        assertEquals(5, darts.score(-5, 0));
    }


    @Test
    void onTheInnerCircle() {
        assertEquals(10, darts.score(0, -1));
    }


    @Test
    void exactlyOnCentre() {
        assertEquals(10, darts.score(0, 0));
    }


    @Test
    void nearTheCentre() {
        assertEquals(10, darts.score(-0.1, -0.1));
    }


    @Test
    void justWithinTheInnerCircle() {
        assertEquals(10, darts.score(0.7, 0.7));
    }


    @Test
    void justOutsideTheInnerCircle() {
        assertEquals(5, darts.score(0.8, -0.8));
    }


    @Test
    void justWithinTheMiddleCircle() {
        assertEquals(5, darts.score(-3.5, 3.5));
    }


    @Test
    void justOutsideTheMiddleCircle() {
        assertEquals(1, darts.score(-3.6, -3.6));
    }


    @Test
    void justWithinTheOuterCircle() {
        assertEquals(1, darts.score(-7.0, 7.0));
    }


    @Test
    void justOutsideTheOuterCircle() {
        assertEquals(0, darts.score(7.1, -7.1));
    }


    @Test
    void asymmetricPositionBetweenTheInnerAndMiddleCircles() {
        assertEquals(5, darts.score(0.5, -4));
    }
}