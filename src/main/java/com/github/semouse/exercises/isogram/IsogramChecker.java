package com.github.semouse.exercises.isogram;

import java.util.HashSet;

/**
 * <a href="https://exercism.org/tracks/java/exercises/isogram">Source</a>
 */
public class IsogramChecker {

    boolean isIsogram(String phrase) {
        return phrase.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .allMatch(new HashSet<>()::add);
    }
}
