package com.github.semouse.exercises.scrabble;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ScrabbleTest {

    @ParameterizedTest
    @MethodSource
    void getScore(int expectedScore, String word) {
        Scrabble scrabble = new Scrabble(word);
        assertEquals(expectedScore, scrabble.getScore());
    }

    private static Stream<Arguments> getScore() {
        return Stream.of(
            Arguments.of(0, ""),
            Arguments.of(1, "a"),
            Arguments.of(1, "A"),
            Arguments.of(4, "f"),
            Arguments.of(2, "at"),
            Arguments.of(12, "zoo"),
            Arguments.of(6, "street"),
            Arguments.of(22, "quirky"),
            Arguments.of(41, "OxyphenButazone"),
            Arguments.of(8, "pinata"),
            Arguments.of(87, "abcdefghijklmnopqrstuvwxyz")
        );
    }
}