package com.github.semouse.exercises.rnatranscription;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RnaTranscriptionTest {

    private final RnaTranscription rnaTranscription = new RnaTranscription();


    @ParameterizedTest
    @MethodSource
    void transcribe(String expectedRNA, String DNA) {
        assertEquals(expectedRNA, rnaTranscription.transcribe(DNA));
    }

    private static Stream<Arguments> transcribe() {
        return Stream.of(
            Arguments.of("", ""),
            Arguments.of("G", "C"),
            Arguments.of("C", "G"),
            Arguments.of("A", "T"),
            Arguments.of("U", "A"),
            Arguments.of("UGCACCAGAAUU", "ACGTGGTCTTAA")
        );
    }
}