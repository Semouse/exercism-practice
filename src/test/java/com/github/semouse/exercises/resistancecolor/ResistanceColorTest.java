package com.github.semouse.exercises.resistancecolor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ResistanceColorTest {

    private final ResistorColor resistorColor = new ResistorColor();

    @Test
    void testBlackColorCode() {
        assertEquals(0, resistorColor.colorCode("black"));
    }

    @Test
    void testWhiteColorCode() {
        assertEquals(9, resistorColor.colorCode("white"));
    }

    @Test
    void testOrangeColorCode() {
        assertEquals(3, resistorColor.colorCode("orange"));
    }

    @Test
    void testColors() {
        String[] expectedColors = new String[]{"black", "brown", "red", "orange", "yellow", "green",
            "blue",
            "violet", "grey", "white"};
        String[] colors = resistorColor.colors();
        assertTrue(expectedColors.length == colors.length && Arrays.stream(expectedColors).toList()
            .containsAll(Arrays.stream(colors).toList()));
    }
}