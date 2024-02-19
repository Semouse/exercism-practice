package com.github.semouse.logslogslogs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LogLineTest {

    @ParameterizedTest
    @CsvSource({"TRC, TRACE", "DBG, DEBUG", "INF, INFO", "WRN, WARNING", "ERR, ERROR",
        "FTL, FATAL", "XYZ, UNKNOWN"})
    void getLogLevel(String logName, String expectedLogLevel) {
        LogLine logLine = new LogLine(String.format("[%s]: message", logName));
        assertEquals(LogLevel.valueOf(expectedLogLevel), logLine.getLogLevel());
    }

    @ParameterizedTest
    @CsvSource({"[ABC]: message, 0:message", "[TRC]: message, 1:message",
        "[DBG]: message, 2:message", "[INF]: message, 4:message", "[WRN]: message, 5:message",
        "[ERR]: message, 6:message", "[FTL]: message, 42:message"})
    void getOutputForShortLog(String line, String expectedOutput) {
        LogLine logLine = new LogLine(line);
        assertEquals(expectedOutput, logLine.getOutputForShortLog());
    }
}