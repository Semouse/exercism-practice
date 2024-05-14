package com.github.semouse.exercises.proverb;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProverbTest {
    @Test
    void zeroWordsAreGiven() {
        String[] words = new String[0];
        assertThat(new Proverb(words).recite()).isEmpty();
    }

    @Test
    void singlePieceOfProverb() {
        String[] words = new String[]{"nail"};
        assertThat(new Proverb(words).recite())
                .isEqualTo("And all for the want of a nail.");
    }

    @Test
    void twoPiecesOfProverb() {
        String[] words = new String[]{"nail", "shoe"};
        assertThat(new Proverb(words).recite())
                .isEqualTo(
                        "For want of a nail the shoe was lost.\n" +
                                "And all for the want of a nail.");
    }

    @Test
    void shortChainOfConsequences() {
        String[] words = new String[]{"nail", "shoe", "horse"};
        assertThat(new Proverb(words).recite())
                .isEqualTo(
                        """
                                For want of a nail the shoe was lost.
                                For want of a shoe the horse was lost.
                                And all for the want of a nail.""");
    }

    @Test
    void fullProverb() {
        String[] words = new String[]{"nail", "shoe", "horse", "rider", "message", "battle", "kingdom"};
        assertThat(new Proverb(words).recite())
                .isEqualTo(
                        """
                                For want of a nail the shoe was lost.
                                For want of a shoe the horse was lost.
                                For want of a horse the rider was lost.
                                For want of a rider the message was lost.
                                For want of a message the battle was lost.
                                For want of a battle the kingdom was lost.
                                And all for the want of a nail.""");
    }

    @Test
    void fourPiecesModernizedProverb() {
        String[] words = new String[]{"pin", "gun", "soldier", "battle"};
        assertThat(new Proverb(words).recite())
                .isEqualTo(
                        """
                                For want of a pin the gun was lost.
                                For want of a gun the soldier was lost.
                                For want of a soldier the battle was lost.
                                And all for the want of a pin.""");
    }
}