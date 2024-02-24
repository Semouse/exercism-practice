package com.github.semouse.exercises.acronym;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AcronymTest {


    @ParameterizedTest
    @MethodSource
    void get(String expectedAcronym, String phrase) {
        Acronym acronym = new Acronym(phrase);
        assertEquals(expectedAcronym, acronym.get());
    }

    private static Stream<Arguments> get() {
        return Stream.of(
            Arguments.of("PNG", "Portable Network Graphics"),
            Arguments.of("ROR", "Ruby on Rails"),
            Arguments.of("FIFO", "First In, First Out"),
            Arguments.of("GIMP", "GNU Image Manipulation Program"),
            Arguments.of("CMOS", "Complementary metal-oxide semiconductor"),
            Arguments.of("SIMUFTA", "Something - I made up from thin air"),
            Arguments.of("HC", "Halley's Comet"),
            Arguments.of("TRNT", "The Road _Not_ Taken"),
            Arguments.of("ROTFLSHTMDCOALM",
                "Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me")
        );
    }
}