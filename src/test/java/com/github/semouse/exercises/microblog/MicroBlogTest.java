package com.github.semouse.exercises.microblog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MicroBlogTest {

    private final MicroBlog blog = new MicroBlog();

    @ParameterizedTest
    @MethodSource
    void testTruncate(String expected, String input) {
        assertEquals(expected, blog.truncate(input));
    }

    private static Stream<Arguments> testTruncate() {
        return Stream.of(
            Arguments.of("Hi", "Hi"),
            Arguments.of("Hello", "Hello there"),
            Arguments.of("Bärte", "Bärteppich"),
            Arguments.of("brühe", "brühe"),
            Arguments.of("Добър", "Добър"),
            Arguments.of("υγειά", "υγειά"),
            Arguments.of("a=πr²", "a=πr²"),
            Arguments.of("∅⊊ℕ⊊ℤ", "∅⊊ℕ⊊ℤ⊊ℚ⊊ℝ⊊ℂ"),
            Arguments.of("Fly 🛫", "Fly 🛫"),
            Arguments.of("💇", "💇"),
            Arguments.of("❄🌡🤧🤒🏥", "❄🌡🤧🤒🏥🕰😀"),
            Arguments.of("🃎🂸🃅🃋🃍", "🃎🂸🃅🃋🃍🃁🃊")
        );
    }
}