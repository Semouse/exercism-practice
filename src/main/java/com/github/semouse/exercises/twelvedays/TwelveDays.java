package com.github.semouse.exercises.twelvedays;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwelveDays {

    private static final String TEMPLATE = "On the %s day of Christmas my true love gave to me: %s\n";
    private static final String[] DAYS = {"", "first", "second", "third", "fourth", "fifth", "sixth", "seventh",
            "eighth", "ninth", "tenth", "eleventh", "twelfth"};
    private static final String[] GIFTS = {"", "a Partridge in a Pear Tree.", "two Turtle Doves, and", "three French " +
            "Hens,", "four Calling Birds,", "five Gold Rings,", "six Geese-a-Laying,", "seven Swans-a-Swimming,",
            "eight Maids-a-Milking,", "nine Ladies Dancing,", "ten Lords-a-Leaping,", "eleven Pipers Piping,",
            "twelve Drummers Drumming,"};

    String verse(int verseNumber) {
        return String.format(TEMPLATE, DAYS[verseNumber], combineGifts(verseNumber));
    }

    String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(this::verse)
                .collect(Collectors.joining("\n"));
    }

    String sing() {
        return verses(1, 12);
    }

    private String combineGifts(int verseNumber) {
        return IntStream.iterate(verseNumber, i -> i > 0, i -> i - 1)
                .mapToObj(i -> GIFTS[i])
                .collect(Collectors.joining(" "));
    }
}
