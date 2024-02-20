package com.github.semouse.wizardsandwarriors.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class WarriorTest {

    @Test
    void isVulnerable() {
        Fighter warrior = new Warrior();
        assertFalse(warrior.isVulnerable());
    }

    @Test
    void getDamagePoints() {
        Fighter warrior = new Warrior();
        Fighter wizard = new Wizard();
        assertEquals(10, warrior.getDamagePoints(wizard));
    }

    @Test
    void testToString() {
        Fighter warrior = new Warrior();
        assertEquals("Fighter is a Warrior", warrior.toString());
    }
}