package com.github.semouse.exercises.matrix;

import java.util.Arrays;

public class Matrix {

    private final int[][] state;

    public Matrix(String matrixAsString) {
        state = Arrays.stream(matrixAsString.split("\n"))
                .map(row -> Arrays.stream(row.split("\\s"))
                        .mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }

    public int[] getRow(int rowNumber) {
        return state[rowNumber - 1];
    }

    public int[] getColumn(int columnNumber) {
        return Arrays.stream(state).mapToInt(ints -> ints[columnNumber - 1]).toArray();
    }
}
