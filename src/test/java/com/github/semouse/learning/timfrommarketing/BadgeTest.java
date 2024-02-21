package com.github.semouse.learning.timfrommarketing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.semouse.learning.timfrommarketing.Badge;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BadgeTest {

    @ParameterizedTest
    @MethodSource
    void print(String expectedOutput, Integer id, String name, String department) {
        Badge badge = new Badge();
        String output = badge.print(id, name, department);
        assertEquals(expectedOutput, output);
    }

    private static Stream<Arguments> print() {
        return Stream.of(
            Arguments.of("[734] - Ernest Johnny Payne - STRATEGIC COMMUNICATION", 734,
                "Ernest Johnny Payne", "Strategic Communication"),
            Arguments.of("Jane Johnson - PROCUREMENT", null, "Jane Johnson", "Procurement"),
            Arguments.of("[254] - Charlotte Hale - OWNER", 254, "Charlotte Hale", null),
            Arguments.of("Charlotte Hale - OWNER", null, "Charlotte Hale", null)
        );
    }
}