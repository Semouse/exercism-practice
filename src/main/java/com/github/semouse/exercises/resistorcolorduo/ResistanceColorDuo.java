package com.github.semouse.exercises.resistorcolorduo;

import java.util.Arrays;

public class ResistanceColorDuo {
    private final String[] defaultColors = new String[]{"black", "brown", "red", "orange", "yellow",
        "green", "blue", "violet", "grey", "white"};

    int value(String[] colors) {
        return resistance(colors[0]) * 10 + resistance(colors[1]);
    }

    private int resistance(String color) {
        return Arrays.asList(defaultColors).indexOf(color);
    }
}
