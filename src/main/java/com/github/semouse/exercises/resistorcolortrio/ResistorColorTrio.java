package com.github.semouse.exercises.resistorcolortrio;

import java.math.BigInteger;
import java.util.Arrays;

public class ResistorColorTrio {

    private final String[] defaultColors = new String[]{"black", "brown", "red", "orange", "yellow",
        "green", "blue", "violet", "grey", "white"};

    String label(String[] colors) {
        String label = resistance(colors);
        long zeros = label.chars().filter(c -> c == '0').count();

        if (zeros >= 3 && zeros < 6) {
            return label.substring(0, label.length() - 3) + " kiloohms";
        } else if (zeros >= 6 && zeros < 9) {
            return label.substring(0, label.length() - 6) + " megaohms";
        } else if (zeros >= 9) {
            return label.substring(0, label.length() - 9) + " gigaohms";
        }
        return label + " ohms";
    }

    private String resistance(String[] colors) {
        return parseFirstColor(colors[0]).add(parseSecondColor(colors[1]))
            .multiply(parseThirdColor(colors[2])).toString();
    }

    private BigInteger parseFirstColor(String color) {
        return BigInteger.valueOf(10L * colorCode(color));
    }

    private BigInteger parseSecondColor(String color) {
        return BigInteger.valueOf(colorCode(color));
    }

    private BigInteger parseThirdColor(String color) {
        return BigInteger.valueOf(10).pow(colorCode(color));
    }

    private int colorCode(String color) {
        return Arrays.asList(defaultColors).indexOf(color);
    }
}

