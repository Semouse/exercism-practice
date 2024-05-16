package com.github.semouse.exercises.sumofmultiples;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <a href="https://exercism.org/tracks/java/exercises/sum-of-multiples">Source</a>
 */
public class SumOfMultiples {

    private final int level;
    private final int[] items;

    public SumOfMultiples(int level, int[] items) {
        this.level = level;
        this.items = items;
    }

    public int getSum() {
        return IntStream.range(0, level)
                .filter(number -> Arrays.stream(items).anyMatch(item -> item > 0 && number % item == 0))
                .sum();
    }
}
