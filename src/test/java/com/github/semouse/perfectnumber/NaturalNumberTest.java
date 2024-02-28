package com.github.semouse.perfectnumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NaturalNumberTest {

    @ParameterizedTest
    @MethodSource
    void testNumberCategory(Classification expected, int value) {
        NaturalNumber number = new NaturalNumber(value);
        assertEquals(expected, number.getClassification());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void testNonNaturalNumber(int value) {
        assertThrows(IllegalArgumentException.class, () -> new NaturalNumber(value),
            "You must supply a natural number (positive integer)");
    }

    private static Stream<Arguments> testNumberCategory() {
        return Stream.of(
            Arguments.of(Classification.PERFECT, 6),
            Arguments.of(Classification.PERFECT, 28),
            Arguments.of(Classification.PERFECT, 33550336),
            Arguments.of(Classification.ABUNDANT, 12),
            Arguments.of(Classification.ABUNDANT, 30),
            Arguments.of(Classification.ABUNDANT, 33550335),
            Arguments.of(Classification.DEFICIENT, 2),
            Arguments.of(Classification.DEFICIENT, 4),
            Arguments.of(Classification.DEFICIENT, 32),
            Arguments.of(Classification.DEFICIENT, 1),
            Arguments.of(Classification.DEFICIENT, 33550337)
        );
    }

}