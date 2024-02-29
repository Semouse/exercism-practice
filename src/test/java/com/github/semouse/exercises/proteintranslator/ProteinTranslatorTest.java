package com.github.semouse.exercises.proteintranslator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ProteinTranslatorTest {

    private final ProteinTranslator translator = new ProteinTranslator();

    @ParameterizedTest
    @MethodSource
    void testTranslate(List<String> expected, String rnaSequence) {
        List<String> actual = translator.translate(rnaSequence);
        assertTrue(expected.containsAll(actual));
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA", "XYZ", "AUGU"})
    void testTranslateInvalidRNASequence(String rnaSequence) {
        assertThrows(IllegalArgumentException.class, () -> translator.translate(rnaSequence),
            "Invalid codon");
    }

    private static Stream<Arguments> testTranslate() {
        return Stream.of(
            Arguments.of(Collections.emptyList(), ""),
            Arguments.of(List.of("Methionine"), "AUG"),
            Arguments.of(List.of("Phenylalanine"), "UUU"),
            Arguments.of(List.of("Phenylalanine"), "UUC"),
            Arguments.of(List.of("Leucine"), "UUA"),
            Arguments.of(List.of("Leucine"), "UUG"),
            Arguments.of(List.of("Serine"), "UCU"),
            Arguments.of(List.of("Serine"), "UCC"),
            Arguments.of(List.of("Serine"), "UCA"),
            Arguments.of(List.of("Serine"), "UCG"),
            Arguments.of(List.of("Tyrosine"), "UAU"),
            Arguments.of(List.of("Tyrosine"), "UAC"),
            Arguments.of(List.of("Cysteine"), "UGU"),
            Arguments.of(List.of("Cysteine"), "UGC"),
            Arguments.of(List.of("Tryptophan"), "UGG"),
            Arguments.of(Collections.emptyList(), "UAA"),
            Arguments.of(Collections.emptyList(), "UAG"),
            Arguments.of(Collections.emptyList(), "UGA"),
            Arguments.of(Collections.emptyList(), "UAGUGG"),
            Arguments.of(List.of("Phenylalanine", "Phenylalanine"), "UUUUUU"),
            Arguments.of(List.of("Leucine", "Leucine"), "UUAUUG"),
            Arguments.of(List.of("Methionine", "Phenylalanine", "Tryptophan"), "AUGUUUUGG"),
            Arguments.of(List.of("Tryptophan"), "UGGUAG"),
            Arguments.of(List.of("Methionine", "Phenylalanine"), "AUGUUUUAA"),
            Arguments.of(List.of("Tryptophan"), "UGGUAGUGG"),
            Arguments.of(List.of("Tryptophan", "Cysteine", "Tyrosine"), "UGGUGUUAUUAAUGGUUU"),
            Arguments.of(List.of("Phenylalanine", "Phenylalanine"), "UUCUUCUAAUGGU")
        );
    }

    /*@Disabled("Remove to run test")

    assertThatExceptionOfType(IllegalArgumentException .class)
            .

    isThrownBy(() ->proteinTranslator.translate("AAA"))
        .

    withMessage("Invalid codon");

    assertThatExceptionOfType(IllegalArgumentException .class)
            .

    isThrownBy(() ->proteinTranslator.translate("XYZ"))
        .

    withMessage("Invalid codon");

    assertThatExceptionOfType(IllegalArgumentException .class)
            .

    isThrownBy(() ->proteinTranslator.translate("AUGU"))
        .

    withMessage("Invalid codon");
}



/**/
}