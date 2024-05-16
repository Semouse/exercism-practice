package com.github.semouse.exercises.cipher;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RotationalCipherTest {
    private RotationalCipher rotationalCipher;

    @Test
    void rotateSingleCharacterBy0() {
        rotationalCipher = new RotationalCipher(0);
        assertThat(rotationalCipher.rotate("a")).isEqualTo("a");
    }

    @Test
    void rotateSingleCharacterBy1() {
        rotationalCipher = new RotationalCipher(1);
        assertThat(rotationalCipher.rotate("a")).isEqualTo("b");
    }

    @Test
    void rotateSingleCharacterBy26() {
        rotationalCipher = new RotationalCipher(26);
        assertThat(rotationalCipher.rotate("a")).isEqualTo("a");
    }

    @Test
    void rotateSingleCharacterBy13() {
        rotationalCipher = new RotationalCipher(13);
        assertThat(rotationalCipher.rotate("m")).isEqualTo("z");
    }

    @Test
    void rotateSingleCharacterWithWrapAround() {
        rotationalCipher = new RotationalCipher(13);
        assertThat(rotationalCipher.rotate("n")).isEqualTo("a");
    }

    @Test
    void rotateCapitalLetters() {
        rotationalCipher = new RotationalCipher(5);
        assertThat(rotationalCipher.rotate("OMG")).isEqualTo("TRL");
    }

    @Test
    void rotateSpaces() {
        rotationalCipher = new RotationalCipher(5);
        assertThat(rotationalCipher.rotate("O M G")).isEqualTo("T R L");
    }

    @Test
    void rotateNumbers() {
        rotationalCipher = new RotationalCipher(4);
        assertThat(rotationalCipher.rotate("Testing 1 2 3 testing")).isEqualTo("Xiwxmrk 1 2 3 xiwxmrk");
    }

    @Test
    void rotatePunctuation() {
        rotationalCipher = new RotationalCipher(21);
        assertThat(rotationalCipher.rotate("Let's eat, Grandma!"))
                .isEqualTo("Gzo'n zvo, Bmviyhv!");
    }

    @Test
    void rotateAllLetters() {
        rotationalCipher = new RotationalCipher(13);
        assertThat(rotationalCipher.rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt."))
                .isEqualTo("The quick brown fox jumps over the lazy dog.");
    }
}