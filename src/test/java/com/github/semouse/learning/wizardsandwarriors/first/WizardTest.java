package com.github.semouse.learning.wizardsandwarriors.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.semouse.learning.wizardsandwarriors.first.Fighter;
import com.github.semouse.learning.wizardsandwarriors.first.Warrior;
import com.github.semouse.learning.wizardsandwarriors.first.Wizard;
import org.junit.jupiter.api.Test;

class WizardTest {

    @Test
    void isVulnerable() {
        Wizard wizard = new Wizard();
        assertTrue(wizard.isVulnerable());

        wizard.prepareSpell();
        assertFalse(wizard.isVulnerable());
    }

    @Test
    void getDamagePoints() {
        Wizard wizard = new Wizard();
        Warrior warrior = new Warrior();

        wizard.prepareSpell();
        wizard.getDamagePoints(warrior);

        assertEquals(12, wizard.getDamagePoints(warrior));
    }

    @Test
    void testToString() {
        Fighter wizard = new Wizard();
        assertEquals("Fighter is a Wizard", wizard.toString());
    }
}