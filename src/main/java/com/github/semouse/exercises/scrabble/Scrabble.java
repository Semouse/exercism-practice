package com.github.semouse.exercises.scrabble;

/**
 * Given a word, compute the Scrabble score for that word.
 */
public class Scrabble {

    private final int score;

    public Scrabble(String word) {
        score = word.chars()
            .mapToObj(i -> (char) i)
            .map(this::compute)
            .reduce(Integer::sum)
            .orElse(0);
    }

    public int getScore() {
        return score;
    }

    private int compute(char letter) {
        return switch (Character.toUpperCase(letter)) {
            case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1;
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> 0;
        };
    }
}
