package com.github.semouse.exercises.grains;

import java.math.BigInteger;

public class Grains {

    private static final int FIELD_SIZE = 64;

    public BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > FIELD_SIZE) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.valueOf(2).pow(square - 1);
    }

    public BigInteger grainsOnBoard() {
        return BigInteger.valueOf(2).pow(FIELD_SIZE).subtract(BigInteger.ONE);
    }

}
