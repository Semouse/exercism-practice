package com.github.semouse.exercises.atbash;

/**
 * <a href="https://exercism.org/tracks/java/exercises/atbash-cipher">Source</a>
 */
public class Atbash {

    private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    String encode(String input) {
        StringBuilder builder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                builder.append(ALPHABET.charAt(ALPHABET.length() - ALPHABET.indexOf(Character.toLowerCase(c)) - 1));
            } else if (Character.isDigit(c)) {
                builder.append(c);
            }

            if (builder.chars().filter(i -> i != ' ').count() % 5 == 0 && builder.charAt(builder.length() - 1) != ' ') {
                builder.append(' ');
            }
        }

        return builder.toString().trim();
    }

    String decode(String input) {
        StringBuilder builder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                builder.append(ALPHABET.charAt(
                        Math.abs(ALPHABET.length() - ALPHABET.indexOf(c) - 1)
                ));
            } else if (Character.isDigit(c)) {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
