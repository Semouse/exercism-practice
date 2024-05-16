package com.github.semouse.exercises.cipher;

/**
 * <a href="https://exercism.org/tracks/java/exercises/rotational-cipher">Source</a>
 */
public class RotationalCipher {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private final int shift;

    RotationalCipher(int shiftKey) {
        this.shift = shiftKey;
    }

    String rotate(String data) {
        StringBuilder builder = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isLetter(c)) {
                char encode = ALPHABET.charAt((ALPHABET.indexOf(Character.toLowerCase(c)) + shift) % 26);
                builder.append(Character.isUpperCase(c) ? Character.toUpperCase(encode) : encode);
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
