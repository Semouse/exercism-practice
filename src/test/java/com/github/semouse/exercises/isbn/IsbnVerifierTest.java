package com.github.semouse.exercises.isbn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsbnVerifierTest {
    private final IsbnVerifier isbnVerifier = new IsbnVerifier();

    @Test
    void validIsbnNumber() {
        assertThat(isbnVerifier.isValid("3-598-21508-8")).isTrue();
    }

    @Test
    void invalidIsbnCheckDigit() {
        assertThat(isbnVerifier.isValid("3-598-21508-9")).isFalse();
    }

    @Test
    void validIsbnNumberWithCheckDigitOfTen() {
        assertThat(isbnVerifier.isValid("3-598-21507-X")).isTrue();
    }

    @Test
    void validIsbnNumberWithCheckDigitPaddedWithLettersIsInvalid() {
        assertThat(isbnVerifier.isValid("ABCDEFG3-598-21507-XQWERTYUI")).isFalse();
    }

    @Test
    void checkDigitIsACharacterOtherThanX() {
        assertThat(isbnVerifier.isValid("3-598-21507-A")).isFalse();
    }

    @Test
    void invalidCheckDigitInIsbn() {
        assertThat(isbnVerifier.isValid("4-598-21507-B")).isFalse();
    }

    @Test
    void invalidCharacterInIsbn() {
        assertThat(isbnVerifier.isValid("3-598-P1581-X")).isFalse();
    }

    @Test
    void xIsOnlyValidAsACheckDigit() {
        assertThat(isbnVerifier.isValid("3-598-2X507-9")).isFalse();
    }

    @Test
    void validIsbnWithoutSeparatingDashes() {
        assertThat(isbnVerifier.isValid("3598215088")).isTrue();
    }

    @Test
    void isbnWithoutSeparatingDashesAndXAsCheckDigit() {
        assertThat(isbnVerifier.isValid("359821507X")).isTrue();
    }

    @Test
    void isbnWithoutCheckDigitAndDashes() {
        assertThat(isbnVerifier.isValid("359821507")).isFalse();
    }

    @Test
    void tooLongIsbnAndNoDashes() {
        assertThat(isbnVerifier.isValid("3598215078X")).isFalse();
    }

    @Test
    void tooShortIsbn() {
        assertThat(isbnVerifier.isValid("00")).isFalse();
    }

    @Test
    void isbnWithoutCheckDigit() {
        assertThat(isbnVerifier.isValid("3-598-21507")).isFalse();
    }

    @Test
    void checkDigitOfXShouldNotBeUsedForZero() {
        assertThat(isbnVerifier.isValid("3-598-21515-X")).isFalse();
    }

    @Test
    void emptyIsbn() {
        assertThat(isbnVerifier.isValid("")).isFalse();
    }

    @Test
    void inputIsNineCharacters() {
        assertThat(isbnVerifier.isValid("134456729")).isFalse();
    }

    @Test
    void invalidCharactersAreNotIgnoredAfterCheckingLength() {
        assertThat(isbnVerifier.isValid("3132P34035")).isFalse();
    }

    @Test
    void invalidCharactersAreNotIgnoredBeforeCheckingLength() {
        assertThat(isbnVerifier.isValid("3598P215088")).isFalse();
    }

    @Test
    void inputIsTooLongButContainsAValidIsbn() {
        assertThat(isbnVerifier.isValid("98245726788")).isFalse();
    }
}