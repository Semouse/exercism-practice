package com.github.semouse.exercises.twofer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoferTest {

    private final Twofer twofer = new Twofer();

    @ParameterizedTest
    @MethodSource
    void testTwoFer(String expectedOutput, String name) {
        assertEquals(expectedOutput, twofer.twofer(name));
    }

    public static Stream<Arguments> testTwoFer() {
        return Stream.of(
            Arguments.of("One for you, one for me.", null),
            Arguments.of("One for Alice, one for me.", "Alice"),
            Arguments.of("One for Bob, one for me.", "Bob")
        );
    }
}