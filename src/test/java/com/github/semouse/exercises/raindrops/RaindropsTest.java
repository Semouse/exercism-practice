package com.github.semouse.exercises.raindrops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RaindropsTest {

    private final Raindrops converter = new Raindrops();

    @ParameterizedTest
    @MethodSource
    void convert(String expected, int number) {
        assertEquals(expected, converter.convert(number));
    }

    private static Stream<Arguments> convert() {
        return Stream.of(
            Arguments.of("1", 1),
            Arguments.of("Pling", 3),
            Arguments.of("Plang", 5),
            Arguments.of("Plong", 7),
            Arguments.of("Pling", 6),
            Arguments.of("8", 8),
            Arguments.of("Pling", 9),
            Arguments.of("Plang", 10),
            Arguments.of("Plong", 14),
            Arguments.of("PlingPlang", 15),
            Arguments.of("PlingPlong", 21),
            Arguments.of("Plang", 25),
            Arguments.of("Pling", 27),
            Arguments.of("PlangPlong", 35),
            Arguments.of("Plong", 49),
            Arguments.of("52", 52),
            Arguments.of("PlingPlangPlong", 105),
            Arguments.of("Plang", 3125)
        );
    }
}