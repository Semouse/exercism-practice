package com.github.semouse.learning.footballmatchreports;

import static org.junit.jupiter.api.Assertions.*;

import com.github.semouse.learning.footballmatchreports.FootballMatchReports;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FootballMatchReportsTest {

    @ParameterizedTest
    @CsvSource({"1, goalie", "2, left back", "3, center back", "4, center back", "5, right back",
        "6, midfielder", "7, midfielder", "8, midfielder", "9, left wing", "10, striker",
        "11, right wing"})
    void onField(int shirtNumber, String expectedPosition) {
        String position = FootballMatchReports.onField(shirtNumber);
        assertEquals(expectedPosition, position);
    }

    @Test
    void onFieldShirtNumberNotCorrect() {
        assertThrows(IllegalArgumentException.class, () -> FootballMatchReports.onField(13));
    }
}