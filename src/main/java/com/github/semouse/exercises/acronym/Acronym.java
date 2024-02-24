package com.github.semouse.exercises.acronym;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Acronym {

    private final String value;

    public Acronym(String phrase) {
        this.value = toAcronym(phrase);
    }

    public String get() {
        return value;
    }

    private String toAcronym(String phrase) {
        String str = phrase.replaceAll("[^a-zA-Z -]", "");
        return Arrays.stream(str.split("[\\s-]"))
            .filter(word -> !word.isEmpty())
            .map(word -> String.valueOf(word.charAt(0)).toUpperCase())
            .collect(Collectors.joining());
    }

}
