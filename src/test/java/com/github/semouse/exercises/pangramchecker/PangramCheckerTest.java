package com.github.semouse.exercises.pangramchecker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PangramCheckerTest {

    private final PangramChecker pangramChecker = new PangramChecker();

    @ParameterizedTest
    @ValueSource(strings = {"abcdefghijklmnopqrstuvwxyz",
        "the quick brown fox jumps over the lazy dog",
        "the_quick_brown_fox_jumps_over_the_lazy_dog",
        "the 1 quick brown fox jumps over the 2 lazy dogs",
        "Five quacking Zephyrs jolt my wax bed."})
    void isPangram(String input) {
        assertTrue(pangramChecker.isPangram(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a quick movement of the enemy will jeopardize five gunboats",
        "five boxing wizards jump quickly at it", "7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog",
        "abcdefghijklm ABCDEFGHIJKLM"})
    void isNotPangram(String input) {
        assertFalse(pangramChecker.isPangram(input));
    }
}