package com.github.semouse.exercises.series;

import java.util.ArrayList;
import java.util.List;


public class Series {

    private final String digits;

    public Series(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("series cannot be empty");
        }
        this.digits = string;
    }

    public List<String> slices(int num) {
        if (num > digits.length()) {
            throw new IllegalArgumentException("slice length cannot be greater than series length");
        } else if (num <= 0) {
            throw new IllegalArgumentException("slice length cannot be negative or zero");
        }

        int left = 0, right = num;
        List<String> result = new ArrayList<>();
        while (right <= digits.length()) {
            result.add(digits.substring(left++, right++));
        }

        return result;
    }
}
