package com.github.semouse.perfectnumber;

import java.util.stream.IntStream;

public class NaturalNumber {

    private final Classification classification;

    NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(
                "You must supply a natural number (positive integer)");
        }

        int aliquotSum = IntStream.range(1, number).filter(i -> number % i == 0).sum();
        if (aliquotSum == number) {
            this.classification = Classification.PERFECT;
        } else if (aliquotSum > number) {
            this.classification = Classification.ABUNDANT;
        } else {
            this.classification = Classification.DEFICIENT;
        }
    }

    Classification getClassification() {
        return classification;
    }
}
