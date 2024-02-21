package com.github.semouse.exercises.reversestring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReverseStringTest {

    @ParameterizedTest
    @MethodSource
    void testReverse(String input, String expected) {
        assertEquals(expected, new ReverseString().reverse(input));
    }

    private static Stream<Arguments> testReverse() {
        return Stream.of(
            Arguments.of("", ""),
            Arguments.of("robot", "tobor"),
            Arguments.of("Ramen", "nemaR"),
            Arguments.of("I'm hungry!", "!yrgnuh m'I"),
            Arguments.of("racecar", "racecar"),
            Arguments.of("drawer", "reward")
        );
    }
}