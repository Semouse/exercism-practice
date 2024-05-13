package com.github.semouse.exercises.series;

public class LargestSeriesProductCalculator {

    private final String number;

    public LargestSeriesProductCalculator(String inputNumber) {
        if (!inputNumber.matches("^\\d*$")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.number = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (number.length() < numberOfDigits) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string "
                    + "to search.");
        }

        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        int start = 0;
        int end = numberOfDigits;
        long largest = 0;

        while (end <= number.length()) {
            String value = number.substring(start, end);
            long multiplication = 1;
            for (char c : value.toCharArray()) {
                multiplication *= Character.getNumericValue(c);
            }
            largest = Math.max(largest, multiplication);
            start++;
            end++;
        }

        return largest;
    }
}
