package com.github.semouse.exercises.luhn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LuhnValidatorTest {

    private final LuhnValidator luhnValidator = new LuhnValidator();

    @Test
    void testSingleDigitStringInvalid() {
        assertThat(luhnValidator.isValid("1")).isFalse();
    }

    @Test
    void testSingleZeroIsInvalid() {
        assertThat(luhnValidator.isValid("0")).isFalse();
    }

    @Test
    void testSimpleValidSINReversedRemainsValid() {
        assertThat(luhnValidator.isValid("059")).isTrue();
    }

    @Test
    void testSimpleValidSINReversedBecomesInvalid() {
        assertThat(luhnValidator.isValid("59")).isTrue();
    }

    @Test
    void testValidCanadianSINValid() {
        assertThat(luhnValidator.isValid("055 444 285")).isTrue();
    }

    @Test
    void testInvalidCanadianSINInvalid() {
        assertThat(luhnValidator.isValid("055 444 286")).isFalse();
    }

    @Test
    void testInvalidCreditCardInvalid() {
        assertThat(luhnValidator.isValid("8273 1232 7352 0569")).isFalse();
    }

    @Test
    void testInvalidLongNumberWithAnEvenRemainder() {
        assertThat(luhnValidator.isValid("1 2345 6789 1234 5678 9012")).isFalse();
    }

    @Test
    void testInvalidLongNumberWithARemainderDivisibleBy5() {
        assertThat(luhnValidator.isValid("1 2345 6789 1234 5678 9013")).isFalse();
    }

    @Test
    void testValidNumberWithAnEvenNumberOfDigits() {
        assertThat(luhnValidator.isValid("095 245 88")).isTrue();
    }

    @Test
    void testValidNumberWithAnOddNumberOfSpaces() {
        assertThat(luhnValidator.isValid("234 567 891 234")).isTrue();
    }

    @Test
    void testValidStringsWithANonDigitAtEndInvalid() {
        assertThat(luhnValidator.isValid("059a")).isFalse();
    }

    @Test
    void testStringContainingPunctuationInvalid() {
        assertThat(luhnValidator.isValid("055-444-285")).isFalse();
    }

    @Test
    void testStringContainingSymbolsInvalid() {
        assertThat(luhnValidator.isValid("055# 444$ 285")).isFalse();
    }

    @Test
    void testSingleSpaceWithZeroInvalid() {
        assertThat(luhnValidator.isValid(" 0")).isFalse();
    }

    @Test
    void testMoreThanSingleZeroValid() {
        assertThat(luhnValidator.isValid("0000 0")).isTrue();
    }

    @Test
    void testDigitNineConvertedToOutputNine() {
        assertThat(luhnValidator.isValid("091")).isTrue();
    }

    @Test
    void testVeryLongInputIsValid() {
        assertThat(luhnValidator.isValid("9999999999 9999999999 9999999999 9999999999")).isTrue();
    }

    @Test
    void testValidLuhnWithOddNumberOfDigitsAndNonZeroFirstDigit() {
        assertThat(luhnValidator.isValid("109")).isTrue();
    }

    @Test
    void testUsingASCIIValueForNonDoubledNonDigitNotAllowed() {
        assertThat(luhnValidator.isValid("055b 444 285")).isFalse();
    }

    @Test
    void testUsingASCIIValueForDoubledNonDigitNotAllowed() {
        assertThat(luhnValidator.isValid(":9")).isFalse();
    }

    @Test
    void testNonNumericNonSpaceCharInMiddleWithSumDivisibleBy10IsNotAllowed() {
        assertThat(luhnValidator.isValid("59%59")).isFalse();
    }

}