package com.github.semouse.wizardsandwarriors;

public class Wizard extends Fighter {

    private boolean isSpellPrepared;

    public void prepareSpell() {
        isSpellPrepared = true;
    }

    @Override
    boolean isVulnerable() {
        return !isSpellPrepared;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        return isSpellPrepared ? 12 : 3;
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }
}
