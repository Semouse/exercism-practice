package com.github.semouse.learning.loglevels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LogLevelsTest {

    @ParameterizedTest
    @MethodSource
    void testMessages(String log, String expectedMessage) {
        String message = LogLevels.message(log);
        assertEquals(expectedMessage, message);
    }

    @ParameterizedTest
    @MethodSource
    void testLogLevels(String log, String expectedLevel) {
        String level = LogLevels.logLevel(log);
        assertEquals(expectedLevel, level);
    }

    @ParameterizedTest
    @MethodSource
    void testReformats(String log, String expectedFormat) {
        String reformat = LogLevels.reformat(log);
        assertEquals(expectedFormat, reformat);
    }

    private static Stream<Arguments> testMessages() {
        return Stream.of(
            Arguments.of("[ERROR]: Invalid operation", "Invalid operation"),
            Arguments.of("[WARNING]:  Disk almost full\r\n", "Disk almost full"),
            Arguments.of("[INFO]: Operation completed", "Operation completed")
        );
    }

    private static Stream<Arguments> testLogLevels() {
        return Stream.of(
            Arguments.of("[ERROR]: Invalid operation", "error"),
            Arguments.of("[WARNING]:  Disk almost full\r\n", "warning"),
            Arguments.of("[INFO]: Operation completed", "info")
        );
    }

    private static Stream<Arguments> testReformats() {
        return Stream.of(
            Arguments.of("[ERROR]: Invalid operation", "Invalid operation (error)"),
            Arguments.of("[WARNING]:  Disk almost full\r\n", "Disk almost full (warning)"),
            Arguments.of("[INFO]: Operation completed", "Operation completed (info)")
        );
    }
}