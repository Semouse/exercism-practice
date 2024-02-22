package com.github.semouse.exercises.highscores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HighScoresTest {

    @Test
    void shouldReturnLatestAddedScore() {
        HighScores highScores = new HighScores(List.of(100, 0, 90, 30));
        assertEquals(30, highScores.latest());
    }

    @Test
    void shouldReturnPersonalBest() {
        HighScores highScores = new HighScores(List.of(40, 100, 70));
        assertEquals(100, highScores.personalBest());
    }

    @ParameterizedTest
    @MethodSource
    void personalTopThree(List<Integer> expectedTopThreeScores, List<Integer> scores) {
        HighScores highScores = new HighScores(scores);
        assertEquals(expectedTopThreeScores, highScores.personalTopThree());
    }

    private static Stream<Arguments> personalTopThree() {
        return Stream.of(
            Arguments.of(List.of(100, 90, 70),
                List.of(10, 30, 90, 30, 100, 20, 10, 0, 30, 40, 40, 70, 70)),
            Arguments.of(List.of(30, 20, 10), List.of(20, 10, 30)),
            Arguments.of(List.of(40, 40, 30), List.of(40, 20, 40, 30)),
            Arguments.of(List.of(70, 30), List.of(30, 70)),
            Arguments.of(List.of(40), List.of(40))
        );
    }

    @Test
    void callingLatestAfterPersonalTopThree() {
        HighScores highScores = new HighScores(List.of(70, 50, 20, 30));
        highScores.personalTopThree();
        assertEquals(30, highScores.latest());
    }

    @Test
    void callingScoresAfterPersonalTopThree() {
        HighScores highScores = new HighScores(List.of(30, 50, 20, 70));
        highScores.personalTopThree();
        assertEquals(List.of(30, 50, 20, 70), highScores.scores());
    }

    @Test
    void callingLatestAfterPersonalBest() {
        HighScores highScores = new HighScores(List.of(20, 70, 15, 25, 30));
        highScores.personalBest();
        assertEquals(30, highScores.latest());
    }

    @Test
    void callingScoresAfterPersonalBest() {
        HighScores highScores = new HighScores(List.of(20, 70, 15, 25, 30));
        highScores.personalBest();
        assertEquals(List.of(20, 70, 15, 25, 30), highScores.scores());
    }
}