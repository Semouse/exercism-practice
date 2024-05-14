package com.github.semouse.exercises.proverb;

/**
 * <a href="https://exercism.org/tracks/java/exercises/proverb">Source</a>
 */
public class Proverb {

    private final String[] trace;

    Proverb(String[] words) {
        this.trace = words;
    }

    String recite() {
        if (trace.length == 0) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < trace.length - 1; i++) {
                builder.append(String.format("For want of a %s the %s was lost.%s",
                        trace[i], trace[i + 1], "\n"));
            }
            builder.append(String.format("And all for the want of a %s.", trace[0]));
            return builder.toString();
        }
    }
}
