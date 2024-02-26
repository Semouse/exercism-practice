package com.github.semouse.exercises.gigasecond;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GigasecondTest {

    @ParameterizedTest
    @MethodSource
    void testGetDateTimeFromLocalDate(LocalDateTime expectedDateTime, LocalDate input) {
        Gigasecond gigaSecond = new Gigasecond(input);
        assertEquals(expectedDateTime, gigaSecond.getDateTime());
    }

    @ParameterizedTest
    @MethodSource
    void testGetDateTimeFromLocalDateTime(LocalDateTime expectedDateTime, LocalDateTime input) {
        Gigasecond gigaSecond = new Gigasecond(input);
        assertEquals(expectedDateTime, gigaSecond.getDateTime());
    }

    private static Stream<Arguments> testGetDateTimeFromLocalDate() {
        return Stream.of(
            Arguments.of(LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40),
                LocalDate.of(2011, Month.APRIL, 25)),
            Arguments.of(LocalDateTime.of(2009, Month.FEBRUARY, 19, 1, 46, 40),
                LocalDate.of(1977, Month.JUNE, 13)),
            Arguments.of(LocalDateTime.of(1991, Month.MARCH, 27, 1, 46, 40),
                LocalDate.of(1959, Month.JULY, 19))
        );
    }

    private static Stream<Arguments> testGetDateTimeFromLocalDateTime() {
        return Stream.of(
            Arguments.of(LocalDateTime.of(2046, Month.OCTOBER, 2, 23, 46, 40),
                LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0)),
            Arguments.of(LocalDateTime.of(2046, Month.OCTOBER, 3, 1, 46, 39),
                LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59))
        );
    }
}