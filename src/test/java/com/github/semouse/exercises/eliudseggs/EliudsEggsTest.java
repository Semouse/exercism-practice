package com.github.semouse.exercises.eliudseggs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EliudsEggsTest {

    private final EliudsEggs eliudsEggs = new EliudsEggs();

    @ParameterizedTest
    @MethodSource
    void testEggsCount(int expectedCount, int number) {
        assertEquals(expectedCount, eliudsEggs.eggCount(number));
    }

    private static Stream<Arguments> testEggsCount() {
        return Stream.of(
            Arguments.of(0, 0),
            Arguments.of(1, 16),
            Arguments.of(4, 89),
            Arguments.of(13, 2000000000)
        );
    }
}