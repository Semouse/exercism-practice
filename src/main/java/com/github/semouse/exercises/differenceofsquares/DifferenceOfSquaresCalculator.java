package com.github.semouse.exercises.differenceofsquares;

import java.util.stream.IntStream;

public class DifferenceOfSquaresCalculator {

    public int computeSquareOfSumTo(int input) {
        int sum = IntStream.rangeClosed(1, input).sum();
        return sum * sum;
    }

    public int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(1, input).map(i -> i * i).sum();
    }

    public int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
