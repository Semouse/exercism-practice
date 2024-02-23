package com.github.semouse.exercises.resistorcolortrio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResistorColorTrioTest {

    private final ResistorColorTrio resistorColorTrio = new ResistorColorTrio();

    @ParameterizedTest
    @MethodSource
    void testLabel(String expectedLabel, String[] colors) {
        assertEquals(expectedLabel, resistorColorTrio.label(colors));
    }

    private static Stream<Arguments> testLabel() {
        return Stream.of(
            Arguments.of("33 ohms", new String[]{"orange", "orange", "black"}),
            Arguments.of("680 ohms", new String[]{"blue", "grey", "brown"}),
            Arguments.of("2 kiloohms", new String[]{"red", "black", "red"}),
            Arguments.of("51 kiloohms", new String[]{"green", "brown", "orange"}),
            Arguments.of("470 kiloohms", new String[]{"yellow", "violet", "yellow"}),
            Arguments.of("67 megaohms", new String[]{"blue", "violet", "blue"}),
            Arguments.of("0 ohms", new String[]{"black", "black", "black"}),
            Arguments.of("99 gigaohms", new String[]{"white", "white", "white"}),
            Arguments.of("8 ohms", new String[]{"black", "grey", "black"}),
            Arguments.of("650 kiloohms", new String[]{"blue", "green", "yellow", "orange"})
        );
    }
}