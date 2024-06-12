package com.github.semouse.exercises.binarysearch;

import java.util.List;

public class BinarySearch {

    private static final String MESSAGE = "Value not in array";
    private final List<Integer> items;

    public BinarySearch(List<Integer> items) {
        this.items = items;
    }

    int indexOf(int item) throws ValueNotFoundException {
        int low = 0;
        int high = items.size() - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            int element = items.get(mid);
            if (element < item) {
                low = mid + 1;
            } else if (element > item) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        throw new ValueNotFoundException(MESSAGE);
    }
}
