package com.github.semouse.exercises.armstrongnumbers;

import java.math.BigInteger;

public class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        String str = String.valueOf(numberToCheck);
        int value = str.chars()
            .map(c -> BigInteger.valueOf(Character.getNumericValue(c)).pow(str.length()).intValue())
            .sum();
        return numberToCheck == value;
    }
}
