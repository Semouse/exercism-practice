package com.github.semouse.exercises.bob;

import java.nio.file.Paths;

/**
 * <a href="https://exercism.org/tracks/java/exercises/bob">Source</a>
 */
public class Bob {

    String hey(String input) {
        input = input.trim();
        if (input.isEmpty()) {
            return "Fine. Be that way!";
        } else if (isUpper(input) && input.endsWith("?")) {
            return "Calm down, I know what I'm doing!";
        } else if (isUpper(input)) {
            return "Whoa, chill out!";
        } else if (input.endsWith("?")) {
            return "Sure.";
        }

        return "Whatever.";
    }

    private boolean isUpper(String input) {
        return input.chars().anyMatch(Character::isLetter) && input.equals(input.toUpperCase());
    }
}

