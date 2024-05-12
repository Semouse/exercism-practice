package com.github.semouse.exercises.diamond;

import java.util.ArrayList;
import java.util.List;

public class DiamondPrinter {
    List<String> printToList(char a) {
        List<String> result = new ArrayList<>();
        int size = (a - 'A') == 0 ? 1 : (a - 'A') * 2 + 1;
        int mid = size / 2;
        int left = mid, right = mid;

        char letter = 'A';
        for (int i = 0; i < size; i++) {
            StringBuilder mask = new StringBuilder(" ".repeat(size));
            mask.setCharAt(left, letter);
            mask.setCharAt(right, letter);
            result.add(mask.toString());

            if (i < mid) {
                left--;
                right++;
                letter = (char) (letter + 1);
            } else {
                left++;
                right--;
                letter = (char) (letter - 1);
            }
        }

        return result;
    }

}
