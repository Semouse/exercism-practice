package com.github.semouse.squeakyclean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SqueakyCleanTest {

    private final SqueakyClean squeakyClean = new SqueakyClean();

    @Test
    void replaceSpaceWithUnderscore() {
        String result = squeakyClean.clean("my   Id");
        assertEquals("my___Id", result);
    }

    @Test
    void convertKebabCaseToCamelCase() {
        String result = squeakyClean.clean("a-bc");
        assertEquals("aBc", result);
    }

    @Test
    void convertLeetspeakToNormalText() {
        String result = squeakyClean.clean("H3ll0 W0rld");
        assertEquals("Hello_World", result);
    }

    @Test
    void omitNonLetterCharacters() {
        String result = squeakyClean.clean("a$#.b");
        assertEquals("ab", result);
    }
}