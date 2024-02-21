package com.github.semouse.learning.secrets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SecretsTest {

    @Test
    void shiftBack() {
        assertEquals(2, Secrets.shiftBack(8, 2));
    }

    @Test
    void setBits() {
        assertEquals(7, Secrets.setBits(5, 3));
    }

    @Test
    void flipBits() {
        assertEquals(14, Secrets.flipBits(5, 11));
    }

    @Test
    void clearBits() {
        assertEquals(4, Secrets.clearBits(5, 11));
    }
}