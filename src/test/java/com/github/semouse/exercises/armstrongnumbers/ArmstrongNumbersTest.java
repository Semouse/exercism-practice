package com.github.semouse.exercises.armstrongnumbers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ArmstrongNumbersTest {

    private final ArmstrongNumbers numbers = new ArmstrongNumbers();

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 153, 9474, 9926315})
    void isArmstrongNumber(int number) {
        assertTrue(numbers.isArmstrongNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 100, 9475, 9926314})
    void isNotArmstrongNumber(int number) {
        assertFalse(numbers.isArmstrongNumber(number));
    }
}