package com.github.semouse.learning.secrets;

public class Secrets {

    private Secrets() {
        throw new IllegalStateException("Utility class");
    }

    public static int shiftBack(int value, int amount) {
        return value >>> amount;
    }

    public static int setBits(int value, int mask) {
        return value | mask;
    }

    public static int flipBits(int value, int mask) {
        return value ^ mask;
    }

    public static int clearBits(int value, int mask) {
        return value & ~mask;
    }
}
