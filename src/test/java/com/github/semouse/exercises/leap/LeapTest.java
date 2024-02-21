package com.github.semouse.exercises.leap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LeapTest {

    private final Leap leap = new Leap();

    @Test
    void testYearNotDivBy4InCommonYear() {
        assertFalse(leap.isLeapYear(2015));
    }

    @Test
    void testYearDivBy2NotDivBy4InCommonYear() {
        assertFalse(leap.isLeapYear(1970));
    }

    @Test
    void testYearDivBy4NotDivBy100InLeapYear() {
        assertTrue(leap.isLeapYear(1996));
    }

    @Test
    void testYearDivBy4And5InLeapYear() {
        assertTrue(leap.isLeapYear(1960));
    }

    @Test
    void testYearDivBy100NotDivBy400InCommonYear() {
        assertFalse(leap.isLeapYear(2100));
    }

    @Test
    void testYearDivBy100NotDivBy3IsNotLeapYear() {
        assertFalse(leap.isLeapYear(1900));
    }

    @Test
    void testYearDivBy400InLeapYear() {
        assertTrue(leap.isLeapYear(2000));
    }

    @Test
    void testYearDivBy400NotDivBy125IsLeapYear() {
        assertTrue(leap.isLeapYear(2400));
    }

    @Test
    void testYearDivBy200NotDivBy400InCommonYear() {
        assertFalse(leap.isLeapYear(1800));
    }
}