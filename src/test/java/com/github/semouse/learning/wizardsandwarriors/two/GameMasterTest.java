package com.github.semouse.learning.wizardsandwarriors.two;

import static org.junit.jupiter.api.Assertions.*;

import com.github.semouse.learning.wizardsandwarriors.two.Character;
import com.github.semouse.learning.wizardsandwarriors.two.Destination;
import com.github.semouse.learning.wizardsandwarriors.two.GameMaster;
import com.github.semouse.learning.wizardsandwarriors.two.TravelMethod;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GameMasterTest {

    private final GameMaster gameMaster = new GameMaster();
    private static Character character;
    private static Destination destination;

    @BeforeAll
    static void beforeAll() {
        character = new Character();
        character.setCharacterClass("Wizard");
        character.setLevel(4);
        character.setHitPoints(28);

        destination = new Destination();
        destination.setName("Muros");
        destination.setInhabitants(732);
    }

    @Test
    void describeCharacter() {
        String characterDescription = gameMaster.describe(character);
        assertEquals("You're a level 4 Wizard with 28 hit points.", characterDescription);
    }

    @Test
    void describeDestination() {
        String destinationDescription = gameMaster.describe(destination);
        assertEquals("You've arrived at Muros, which has 732 inhabitants.", destinationDescription);
    }

    @Test
    void describeTravelMethod() {
        assertEquals("You're traveling to your destination on horseback.",
            gameMaster.describe(TravelMethod.HORSEBACK));
        assertEquals("You're traveling to your destination by walking.",
            gameMaster.describe(TravelMethod.WALKING));
    }

    @Test
    void describeCharacterDefaultTravelDestination() {
        String description = gameMaster.describe(character, destination);
        assertEquals(
            "You're a level 4 Wizard with 28 hit points. You're traveling to your destination by walking. You've arrived at Muros, which has 732 inhabitants.",
            description);
    }

    @Test
    void describeCharacterTravelDestination() {
        String description = gameMaster.describe(character, TravelMethod.HORSEBACK, destination);
        assertEquals(
            "You're a level 4 Wizard with 28 hit points. You're traveling to your destination on horseback. You've arrived at Muros, which has 732 inhabitants.",
            description);
    }
}