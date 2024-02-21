package com.github.semouse.exercises.dndcharacter;

import java.util.List;
import java.util.Random;

public class DnDCharacter {

    private static final Random random = new Random();

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    public DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
    }

    public int ability(List<Integer> scores) {
        Integer min = scores.stream().min(Integer::compare).orElse(0);
        return scores.stream().reduce(0, Integer::sum) - min;
    }

    public List<Integer> rollDice() {
        return random.ints(4, 1, 6).boxed().toList();
    }

    public int modifier(int input) {
        return (int) Math.floor((input - 10) / 2.0);
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getHitpoints() {
        return 10 + modifier(constitution);
    }
}
