package com.github.semouse.exercises.luhn;

/**
 * <a href="https://exercism.org/tracks/java/exercises/luhn">Source</a>
 */
public class LuhnValidator {
    public boolean isValid(String candidate) {
        int sum = 0;
        int factor = 2;
        int digitCount = 0;
        for (int i = candidate.length() - 1; i >= 0; i--) {
            char value = candidate.charAt(i);
            if (value == ' ') {
                continue;
            }
            if (value < '0' || value > '9') {
                return false;
            }

            factor = 3 - factor;
            int digit = Character.getNumericValue(value) * factor;
            digitCount++;
            if (digit > 9) {
                digit -= 9;
            }
            sum += digit;
        }

        return digitCount > 1 && sum % 10 == 0;
    }
}
