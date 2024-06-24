package com.github.semouse.exercises.bottlesong;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BottleSongTest {

    private final BottleSong bottleSong = new BottleSong();

    @Test
    public void firstGenericVerse() {
        assertThat(bottleSong.recite(10, 1)).isEqualTo(
                """
                        Ten green bottles hanging on the wall,
                        Ten green bottles hanging on the wall,
                        And if one green bottle should accidentally fall,
                        There'll be nine green bottles hanging on the wall.
                        """
        );
    }

    @Test
    public void lastGenericVerse() {
        assertThat(bottleSong.recite(3, 1)).isEqualTo(
                """
                        Three green bottles hanging on the wall,
                        Three green bottles hanging on the wall,
                        And if one green bottle should accidentally fall,
                        There'll be two green bottles hanging on the wall.
                        """
        );
    }

    @Test
    public void verseWithTwoBottles() {
        assertThat(bottleSong.recite(2, 1)).isEqualTo(
                """
                        Two green bottles hanging on the wall,
                        Two green bottles hanging on the wall,
                        And if one green bottle should accidentally fall,
                        There'll be one green bottle hanging on the wall.
                        """
        );
    }

    @Test
    public void verseWithOneBottle() {
        assertThat(bottleSong.recite(1, 1)).isEqualTo(
                """
                        One green bottle hanging on the wall,
                        One green bottle hanging on the wall,
                        And if one green bottle should accidentally fall,
                        There'll be no green bottles hanging on the wall.
                        """
        );
    }

    @Test
    public void firstTwoVerses() {
        assertThat(bottleSong.recite(10, 2)).isEqualTo(
                """
                        Ten green bottles hanging on the wall,
                        Ten green bottles hanging on the wall,
                        And if one green bottle should accidentally fall,
                        There'll be nine green bottles hanging on the wall.

                        Nine green bottles hanging on the wall,
                        Nine green bottles hanging on the wall,
                        And if one green bottle should accidentally fall,
                        There'll be eight green bottles hanging on the wall.
                        """
        );
    }

    @Test
    public void lastThreeVerses() {
        assertThat(bottleSong.recite(3, 3)).isEqualTo(
                """
                        Three green bottles hanging on the wall,
                        Three green bottles hanging on the wall,
                        And if one green bottle should accidentally fall,
                        There'll be two green bottles hanging on the wall.

                        Two green bottles hanging on the wall,
                        Two green bottles hanging on the wall,
                        And if one green bottle should accidentally fall,
                        There'll be one green bottle hanging on the wall.

                        One green bottle hanging on the wall,
                        One green bottle hanging on the wall,
                        And if one green bottle should accidentally fall,
                        There'll be no green bottles hanging on the wall.
                        """
        );
    }

    @Test
    public void allVerses() {
        assertThat(bottleSong.recite(10, 10))
                .isEqualTo(
                        """
                                Ten green bottles hanging on the wall,
                                Ten green bottles hanging on the wall,
                                And if one green bottle should accidentally fall,
                                There'll be nine green bottles hanging on the wall.

                                Nine green bottles hanging on the wall,
                                Nine green bottles hanging on the wall,
                                And if one green bottle should accidentally fall,
                                There'll be eight green bottles hanging on the wall.

                                Eight green bottles hanging on the wall,
                                Eight green bottles hanging on the wall,
                                And if one green bottle should accidentally fall,
                                There'll be seven green bottles hanging on the wall.

                                Seven green bottles hanging on the wall,
                                Seven green bottles hanging on the wall,
                                And if one green bottle should accidentally fall,
                                There'll be six green bottles hanging on the wall.

                                Six green bottles hanging on the wall,
                                Six green bottles hanging on the wall,
                                And if one green bottle should accidentally fall,
                                There'll be five green bottles hanging on the wall.

                                Five green bottles hanging on the wall,
                                Five green bottles hanging on the wall,
                                And if one green bottle should accidentally fall,
                                There'll be four green bottles hanging on the wall.

                                Four green bottles hanging on the wall,
                                Four green bottles hanging on the wall,
                                And if one green bottle should accidentally fall,
                                There'll be three green bottles hanging on the wall.

                                Three green bottles hanging on the wall,
                                Three green bottles hanging on the wall,
                                And if one green bottle should accidentally fall,
                                There'll be two green bottles hanging on the wall.

                                Two green bottles hanging on the wall,
                                Two green bottles hanging on the wall,
                                And if one green bottle should accidentally fall,
                                There'll be one green bottle hanging on the wall.

                                One green bottle hanging on the wall,
                                One green bottle hanging on the wall,
                                And if one green bottle should accidentally fall,
                                There'll be no green bottles hanging on the wall.
                                """
                );
    }

}