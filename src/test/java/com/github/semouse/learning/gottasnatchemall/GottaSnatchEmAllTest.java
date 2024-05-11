package com.github.semouse.learning.gottasnatchemall;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GottaSnatchEmAllTest {

    @Test
    void testCommonCardsAllCardsDifferent() {
        List<Set<String>> collections = List.of(Set.of("Veevee"), Set.of("Bleakachu"), Set.of("Wigglycream"));
        Set<String> expected = Set.of();
        assertEquals(expected, GottaSnatchEmAll.commonCards(collections));
    }
}