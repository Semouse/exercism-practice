package com.github.semouse.exercises.grains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class GrainsTest {

    private final Grains grains = new Grains();

    @ParameterizedTest
    @MethodSource
    void grainsOnSquare(BigInteger expectedResult, int square) {
        assertEquals(expectedResult, grains.grainsOnSquare(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 65})
    void invalidGrainsOnSquare(int square) {
        assertThrows(IllegalArgumentException.class, () -> grains.grainsOnSquare(square),
            "Square must be between 1 and 64");
    }

    @Test
    void totalNumberOfGrainsOnABoard() {
        assertEquals(new BigInteger("18446744073709551615"), grains.grainsOnBoard());
    }

    private static Stream<Arguments> grainsOnSquare() {
        return Stream.of(
            Arguments.of(BigInteger.valueOf(1), 1),
            Arguments.of(BigInteger.valueOf(2), 2),
            Arguments.of(BigInteger.valueOf(4), 3),
            Arguments.of(BigInteger.valueOf(8), 4),
            Arguments.of(BigInteger.valueOf(32768), 16),
            Arguments.of(new BigInteger("2147483648"), 32),
            Arguments.of(new BigInteger("9223372036854775808"), 64)

        );
    }
}