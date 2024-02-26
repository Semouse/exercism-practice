package com.github.semouse.exercises.hamming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HammingTest {

    @ParameterizedTest
    @MethodSource
    void validInput(int expectedDistance, String leftStrand, String rightStrand) {
        Hamming hamming = new Hamming(leftStrand, rightStrand);
        assertEquals(expectedDistance, hamming.getHammingDistance());
    }

    private static Stream<Arguments> validInput() {
        return Stream.of(
            Arguments.of(0, "", ""),
            Arguments.of(0, "A", "A"),
            Arguments.of(1, "G", "T"),
            Arguments.of(0, "GGACTGAAATCTG", "GGACTGAAATCTG"),
            Arguments.of(9, "GGACGGATTCTG", "AGGACGGATTCT")
        );
    }

    @ParameterizedTest
    @MethodSource
    void invalidInput(String leftStrand, String rightStrand) {
        assertThrows(IllegalArgumentException.class, () -> new Hamming(leftStrand, rightStrand),
            "strands must be of equal length");
    }

    private static Stream<Arguments> invalidInput() {
        return Stream.of(
            Arguments.of("AATG", "AAA"),
            Arguments.of("ATA", "AGTG"),
            Arguments.of("", "G"),
            Arguments.of("G", "")
        );
    }
}