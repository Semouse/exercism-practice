package com.github.semouse.exercises.yacht;

/**
 * <a href="https://exercism.org/tracks/java/exercises/yacht">Source</a>
 */
public class Yacht {

    private final int[] dices;
    private final YachtCategory category;

    public Yacht(int[] dices, YachtCategory yachtCategory) {
        this.dices = dices;
        this.category = yachtCategory;
    }

    public int score() {
        return category.score(dices);
    }
}
