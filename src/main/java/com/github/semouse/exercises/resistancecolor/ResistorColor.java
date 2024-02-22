package com.github.semouse.exercises.resistancecolor;

import java.util.Arrays;

public class ResistorColor {

    private final String[] colors = new String[]{"black", "brown", "red", "orange", "yellow",
        "green", "blue", "violet", "grey", "white"};

    public int colorCode(String color) {
        return Arrays.asList(colors).indexOf(color);
    }

    public String[] colors() {
        return colors;
    }
}
