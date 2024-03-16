package com.github.semouse.exercises.say;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class SayTest {

    private final Say sayer = new Say();

    @ParameterizedTest
    @MethodSource
    void say(String expected, long number) {
        assertEquals(expected, sayer.say(number));
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, 1_000_000_000_000L})
    void sayException(long number) {
        assertThrows(IllegalArgumentException.class, () -> sayer.say(number));
    }

    private static Stream<Arguments> say() {
        return Stream.of(
            Arguments.of("zero", 0),
            Arguments.of("one", 1),
            Arguments.of("fourteen", 14),
            Arguments.of("twenty", 20),
            Arguments.of("twenty-two", 22),
            Arguments.of("thirty", 30),
            Arguments.of("ninety-nine", 99),
            Arguments.of("one hundred", 100),
            Arguments.of("one hundred twenty-three", 123),
            Arguments.of("two hundred", 200),
            Arguments.of("nine hundred ninety-nine", 999),
            Arguments.of("one thousand", 1_000),
            Arguments.of("one thousand two hundred thirty-four", 1_234),
            Arguments.of("one million", 1_000_000),
            Arguments.of("one million two thousand three hundred forty-five", 1_002_345),
            Arguments.of("one billion", 1_000_000_000),
            Arguments.of("nine hundred eighty-seven billion six hundred fifty-four million" +
                " three hundred twenty-one thousand one hundred twenty-three", 987_654_321_123L)
        );
    }


    /*
    @Disabled("Remove to run test")
    @Test
    public void illegalNegativeNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> say.say(-1));
    }
    @Disabled("Remove to run test")
    @Test
    public void illegalTooBigNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> say.say(1_000_000_000_000L));
    }*/
}