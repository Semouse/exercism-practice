package com.github.semouse.exercises.proteintranslator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProteinTranslator {

    public List<String> translate(String rnaSequence) {
        if (rnaSequence.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < rnaSequence.length(); i += 3) {
            String codon = getCodon(rnaSequence, i);
            String protein = getProtein(codon);

            if ("STOP".equals(protein)) {
                break;
            } else {
                result.add(protein);
            }
        }

        return result;
    }

    private String getCodon(String rnaSequence, int startIndex) {
        if (startIndex + 3 > rnaSequence.length()) {
            throw new IllegalArgumentException("Invalid codon");
        }

        return rnaSequence.substring(startIndex, startIndex + 3);
    }

    private String getProtein(String codon) {
        return switch (codon) {
            case "AUG" -> "Methionine";
            case "UUU", "UUC" -> "Phenylalanine";
            case "UUA", "UUG" -> "Leucine";
            case "UCU", "UCC", "UCA", "UCG" -> "Serine";
            case "UAU", "UAC" -> "Tyrosine";
            case "UGU", "UGC" -> "Cysteine";
            case "UGG" -> "Tryptophan";
            case "UAA", "UAG", "UGA" -> "STOP";
            default -> throw new IllegalArgumentException("Invalid codon");
        };
    }
}
