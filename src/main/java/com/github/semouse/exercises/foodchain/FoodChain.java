package com.github.semouse.exercises.foodchain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FoodChain {

    private static final Map<Integer, String> VERSES = new HashMap<>();

    static {
        VERSES.put(1, """
                I know an old lady who swallowed a fly.
                I don't know why she swallowed the fly. Perhaps she'll die.""");
        VERSES.put(2, """
                I know an old lady who swallowed a spider.
                It wriggled and jiggled and tickled inside her.""");
    }

    String verse(int verse) {
        return IntStream.iterate(verse, i -> i >= 1, i -> i - 1).mapToObj(VERSES::get).collect(Collectors.joining());
    }

    String verses(int startVerse, int endVerse) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
