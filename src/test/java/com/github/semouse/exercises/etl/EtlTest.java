package com.github.semouse.exercises.etl;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class EtlTest {
    private final Etl etl = new Etl();

    @Test
    public void testTransformOneValue() {
        Map<Integer, List<String>> old = Map.of(1, List.of("A"));
        Map<String, Integer> expected = Map.of("a", 1);
        assertThat(etl.transform(old)).isEqualTo(expected);
    }

    @Test
    public void testTransformMoreValues() {
        Map<Integer, List<String>> old = Map.of(1, Arrays.asList("A", "E", "I", "O", "U"));
        Map<String, Integer> expected = Map.of("a", 1, "e", 1, "i", 1, "o", 1, "u", 1);
        assertThat(etl.transform(old)).isEqualTo(expected);
    }

    @Test
    public void testMoreKeys() {
        Map<Integer, List<String>> old = Map.of(1, Arrays.asList("A", "E"), 2, Arrays.asList("D", "G"));
        Map<String, Integer> expected = Map.of("a", 1, "e", 1, "d", 2, "g", 2);
        assertThat(etl.transform(old)).isEqualTo(expected);
    }

    @Test
    public void testFullDataset() {
        Map<Integer, List<String>> old = new HashMap<>() {
            {
                put(1, Arrays.asList("A", "E", "I", "O", "U", "L", "N", "R", "S", "T"));
                put(2, Arrays.asList("D", "G"));
                put(3, Arrays.asList("B", "C", "M", "P"));
                put(4, Arrays.asList("F", "H", "V", "W", "Y"));
                put(5, List.of("K"));
                put(8, Arrays.asList("J", "X"));
                put(10, Arrays.asList("Q", "Z"));
            }
        };
        old = Collections.unmodifiableMap(old);
        Map<String, Integer> expected = new HashMap<>() {
            {
                put("a", 1);
                put("b", 3);
                put("c", 3);
                put("d", 2);
                put("e", 1);
                put("f", 4);
                put("g", 2);
                put("h", 4);
                put("i", 1);
                put("j", 8);
                put("k", 5);
                put("l", 1);
                put("m", 3);
                put("n", 1);
                put("o", 1);
                put("p", 3);
                put("q", 10);
                put("r", 1);
                put("s", 1);
                put("t", 1);
                put("u", 1);
                put("v", 4);
                put("w", 4);
                put("x", 8);
                put("y", 4);
                put("z", 10);
            }
        };
        expected = Collections.unmodifiableMap(expected);
        assertThat(etl.transform(old)).isEqualTo(expected);
    }
}