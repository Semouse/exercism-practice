package com.github.semouse.exercises.etl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> result = new HashMap<>();
        old.forEach((key, value) -> value.forEach(letter -> result.put(letter.toLowerCase(), key)));

        return result;
    }
}
