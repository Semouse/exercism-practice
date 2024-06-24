package com.github.semouse.exercises.bowling.classic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {

    private BowlingGame game;

    @BeforeEach
    public void init() {
        game = new BowlingGame();
    }

    @Test
    void testGutterGame() {
        roll(20, 0);
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    void testAllOnes() {
        roll(20, 1);
        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    void testOneSpare() {
        rollSpare();
        game.roll(3);
        roll(17, 0);
        assertThat(game.score()).isEqualTo(16);
    }

    @Test
    void testOneStrike() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        roll(16, 0);
        assertThat(game.score()).isEqualTo(24);
    }

    @Test
    void testPerfectGame(){
        roll(12, 10);
        assertThat(game.score()).isEqualTo(300);
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void roll(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
}