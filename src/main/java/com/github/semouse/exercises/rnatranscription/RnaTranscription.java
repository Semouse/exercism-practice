package com.github.semouse.exercises.rnatranscription;

import java.util.Map;

public class RnaTranscription {

    private static final Map<Character, Character> DNA_TO_RNA_TRANSLATION_TABLE = Map.of('G', 'C',
        'C', 'G', 'T', 'A', 'A', 'U');

    public String transcribe(String dnaStrand) {
        return dnaStrand.chars()
            .mapToObj(c -> DNA_TO_RNA_TRANSLATION_TABLE.get((char) c))
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
