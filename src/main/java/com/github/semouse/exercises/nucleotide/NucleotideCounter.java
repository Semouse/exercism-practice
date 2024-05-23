package com.github.semouse.exercises.nucleotide;

import java.util.HashMap;
import java.util.Map;

public class NucleotideCounter {
    private static final String NUCLEOTIDES = "ACGT";

    private final Map<Character, Integer> counts = new HashMap<>(Map.of('A', 0, 'C', 0, 'T', 0, 'G', 0));

    public NucleotideCounter(String sequence) {
        for (char nucleotide : sequence.toCharArray()) {
            if (NUCLEOTIDES.indexOf(nucleotide) == -1) {
                throw new IllegalArgumentException();
            }
            counts.merge(nucleotide, 1, Integer::sum);
        }
    }

    public Map<Character, Integer> nucleotideCounts() {
        return counts;
    }
}
