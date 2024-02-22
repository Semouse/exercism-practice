package com.github.semouse.exercises.resistorcolorduo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResistanceColorDuoTest {

    private final ResistanceColorDuo resistanceColorDuo = new ResistanceColorDuo();

    @ParameterizedTest
    @MethodSource
    void value(int expectedResistance, String[] colors) {
        assertEquals(expectedResistance, resistanceColorDuo.value(colors));
    }

    private static Stream<Arguments> value() {
        return Stream.of(
            Arguments.of(10, new String[]{"brown", "black"}),
            Arguments.of(68, new String[]{"blue", "grey"}),
            Arguments.of(47, new String[]{"yellow", "violet"}),
            Arguments.of(33, new String[]{"orange", "orange"}),
            Arguments.of(92, new String[]{"white", "red"}),
            Arguments.of(1, new String[]{"black", "brown"}),
            Arguments.of(51, new String[]{"green", "brown", "orange"})
        );
    }
}