package com.github.semouse.exercises.piglatin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PigLatinTranslator {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    private static final Set<String> SPECIALS = Set.of("xr", "yt");

    public String translate(String phrase) {
        List<String> result = new ArrayList<>();
        String[] words = phrase.split(" ");

        for (String word : words) {
            if (VOWELS.contains(word.charAt(0)) || SPECIALS.contains(word.substring(0, 2))) {
                result.add(word + "ay");
            } else {
                int position = 1;
                while (position < word.length()) {
                    char letter = word.charAt(position);
                    if (VOWELS.contains(letter) || letter == 'y') {
                        if (letter == 'u' && word.charAt(position - 1) == 'q') {
                            position++;
                        }
                        result.add(word.substring(position) + word.substring(0, position) + "ay");
                        break;
                    }
                    position++;
                }
            }
        }

        return String.join(" ", result);
    }
}
