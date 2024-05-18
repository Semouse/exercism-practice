package com.github.semouse.exercises.allergies;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://exercism.org/tracks/java/exercises/allergies">Source</a>
 */
public class Allergies {
    private final int score;

    public Allergies(int score) {
        this.score = score;
    }

    public boolean isAllergicTo(Allergen allergen) {
        return (score & allergen.getScore()) != 0;
    }

    public List<Allergen> getList() {
        return Arrays.stream(Allergen.values())
                .filter(this::isAllergicTo)
                .toList();
    }
}
