package com.github.semouse.exercises.series;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LargestSeriesProductCalculatorTest {
    @ParameterizedTest
    @MethodSource
    void calculateLargestProductForSeriesLength(String inputNumber, int numberOfDigits, long expectedProduct) {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator(inputNumber);
        long actualProduct = calculator.calculateLargestProductForSeriesLength(numberOfDigits);
        assertThat(actualProduct).isEqualTo(expectedProduct);
    }

    @Test
    void testSeriesLengthLongerThanLengthOfStringToTestIsRejected() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("123");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculateLargestProductForSeriesLength(4))
                .withMessage("Series length must be less than or equal to the length of the string to search.");
    }

    @Test
    void testEmptyStringToSearchAndSeriesOfNonZeroLengthIsRejected() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculateLargestProductForSeriesLength(1))
                .withMessage("Series length must be less than or equal to the length of the string to search.");
    }

    @Test
    void testStringToSearchContainingNonDigitCharacterIsRejected() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LargestSeriesProductCalculator("1234a5"))
                .withMessage("String to search may only contain digits.");
    }

    @Test
    void testNegativeSeriesLengthIsRejected() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("12345");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculateLargestProductForSeriesLength(-1))
                .withMessage("Series length must be non-negative.");
    }

    @Test
    void testForIntegerOverflow() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("9999999999");
        long expectedProduct = 3486784401L;
        long actualProduct = calculator.calculateLargestProductForSeriesLength(10);
        assertThat(actualProduct).isEqualTo(expectedProduct);
    }

    private static Stream<Arguments> calculateLargestProductForSeriesLength() {
        return Stream.of(
                Arguments.of("29", 2, 18L),
                Arguments.of("0123456789", 2, 72L),
                Arguments.of("576802143", 2, 48L),
                Arguments.of("0123456789", 3, 504L),
                Arguments.of("1027839564", 3, 270L),
                Arguments.of("0123456789", 5, 15120L),
                Arguments.of("73167176531330624919225119674426574742355349194934", 6, 23520L),
                Arguments.of("0000", 2, 0L),
                Arguments.of("99099", 3, 0L)
        );
    }
}