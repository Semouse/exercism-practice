package com.github.semouse.exercises.dndcharacter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DnDCharacterTest {

    private final DnDCharacter dndCharacter = new DnDCharacter();

    @ParameterizedTest
    @MethodSource
    void testModifier(int expectedModifier, int input) {
        assertEquals(expectedModifier, dndCharacter.modifier(input));
    }

    @Test
    void testRollDice() {
        List<Integer> rolls = dndCharacter.rollDice();
        assertEquals(4, rolls.size());
        assertTrue(rolls.stream().allMatch(i -> i >= 1 && i <= 6));
    }

    @ParameterizedTest
    @MethodSource
    void testAbility(int expectedAbility, List<Integer> scores) {
        assertEquals(expectedAbility, dndCharacter.ability(scores));
    }

    @Test
    void testRandomCharacterIsValid() {
        for (int i = 0; i < 1000; i++) {
            DnDCharacter character = new DnDCharacter();
            assertTrue(character.getStrength() > 2 && character.getStrength() < 19);
            assertTrue(character.getDexterity() > 2 && character.getDexterity() < 19);
            assertTrue(character.getConstitution() > 2 && character.getConstitution() < 19);
            assertTrue(character.getIntelligence() > 2 && character.getIntelligence() < 19);
            assertTrue(character.getWisdom() > 2 && character.getWisdom() < 19);
            assertTrue(character.getCharisma() > 2 && character.getCharisma() < 19);
            assertEquals(10 + character.modifier(character.getConstitution()),
                character.getHitpoints());
        }
    }

    @Test
    void testUniqueCharacterIsCreated() {
        DnDCharacter uniqueDnDCharacter = new DnDCharacter();
        for (int i = 0; i < 1000; i++) {
            DnDCharacter dnDCharacter = new DnDCharacter();
            boolean dnDCharactersHaveDifferentAttributes =
                dnDCharacter.getStrength() != uniqueDnDCharacter.getStrength()
                    || dnDCharacter.getDexterity() != uniqueDnDCharacter.getDexterity()
                    || dnDCharacter.getConstitution() != uniqueDnDCharacter.getConstitution()
                    || dnDCharacter.getIntelligence() != uniqueDnDCharacter.getIntelligence()
                    || dnDCharacter.getWisdom() != uniqueDnDCharacter.getWisdom()
                    || dnDCharacter.getCharisma() != uniqueDnDCharacter.getCharisma()
                    || dnDCharacter.getHitpoints() != uniqueDnDCharacter.getHitpoints();
            assertTrue(dnDCharactersHaveDifferentAttributes);
        }
    }

    private static Stream<Arguments> testModifier() {
        return Stream.of(
            Arguments.of(-4, 3),
            Arguments.of(-3, 4),
            Arguments.of(-3, 5),
            Arguments.of(-2, 6),
            Arguments.of(-2, 7),
            Arguments.of(-1, 8),
            Arguments.of(-1, 9),
            Arguments.of(0, 10),
            Arguments.of(0, 11),
            Arguments.of(1, 12),
            Arguments.of(1, 13),
            Arguments.of(2, 14),
            Arguments.of(2, 15),
            Arguments.of(3, 16),
            Arguments.of(3, 17),
            Arguments.of(4, 18)
        );
    }

    private static Stream<Arguments> testAbility() {
        return Stream.of(
            Arguments.of(9, List.of(4, 3, 2, 1)),
            Arguments.of(9, List.of(1, 2, 3, 4)),
            Arguments.of(9, List.of(2, 4, 3, 1)),
            Arguments.of(3, List.of(1, 1, 1, 1)),
            Arguments.of(18, List.of(6, 6, 6, 6))
        );
    }
}