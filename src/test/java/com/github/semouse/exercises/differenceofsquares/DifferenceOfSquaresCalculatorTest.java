package com.github.semouse.exercises.differenceofsquares;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DifferenceOfSquaresCalculatorTest {

    private final DifferenceOfSquaresCalculator calculator = new DifferenceOfSquaresCalculator();

    @ParameterizedTest
    @CsvSource({"1, 1", "225, 5", "25502500, 100"})
    void testSquareOfSumUpToOne(int expected, int input) {
        int actual = calculator.computeSquareOfSumTo(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "55, 5", "338350, 100"})
    void testSumOfSquaresUpToOne(int expected, int input) {
        int actual = calculator.computeSumOfSquaresTo(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "170, 5", "25164150, 100"})
    void testDifferenceOfSquaresUpToOne(int expected, int input) {
        int actual = calculator.computeDifferenceOfSquares(input);
        assertEquals(expected, actual);
    }
}