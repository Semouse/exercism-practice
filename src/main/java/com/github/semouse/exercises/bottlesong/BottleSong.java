package com.github.semouse.exercises.bottlesong;

import java.util.Map;

public class BottleSong {

    private static final Map<Integer, String> DIGIT_TO_WORD =
            Map.of(10, "Ten", 9, "Nine", 8, "Eight", 7, "Seven", 6, "Six", 5, "Five",
                    4, "Four", 3, "Three", 2, "Two", 1, "One");

    private static final String SONG_TEXT = """
            %s green %s hanging on the wall,
            %s green %s hanging on the wall,
            And if one green bottle should accidentally fall,
            There'll be %s green %s hanging on the wall.
            """;

    public String recite(int startBottles, int takeDown) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < takeDown; i++) {
            if (i != 0) {
                builder.append("\n");
            }
            builder.append(
                    SONG_TEXT.formatted(
                            DIGIT_TO_WORD.get(startBottles),
                            startBottles == 1 ? "bottle" : "bottles",
                            DIGIT_TO_WORD.get(startBottles),
                            startBottles == 1 ? "bottle" : "bottles",
                            DIGIT_TO_WORD.getOrDefault(startBottles - 1, "no").toLowerCase(),
                            startBottles - 1 == 1 ? "bottle" : "bottles"
                    )
            );
            startBottles--;
        }

        return builder.toString();
    }
}
