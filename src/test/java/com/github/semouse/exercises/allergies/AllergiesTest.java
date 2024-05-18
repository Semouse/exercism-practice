package com.github.semouse.exercises.allergies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class AllergiesTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 2})
    void notAllergicToEggs(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 255})
    void allergicToEggs(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5})
    void notAllergicToPeanuts(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 7, 255})
    void allergicToPeanuts(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void notAllergicToShellfish(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 14, 255})
    void allergicToShellfish(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 20})
    void notAllergicToStrawberries(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 28, 255})
    void allergicToStrawberries(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 40})
    void notAllergicToTomatoes(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {16, 56, 255})
    void allergicToTomatoes(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 80})
    void notAllergicToChocolate(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {32, 112, 255})
    void chocolateAllergicOnlyToChocolate(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 160})
    void notAllergicToPollen(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {64, 224, 255})
    void pollenAllergicOnlyToPollen(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 64})
    void notAllergicToCats(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.CATS)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {128, 192, 255})
    void catsAllergicOnlyToCats(int score) {
        Allergies allergies = new Allergies(score);
        assertThat(allergies.isAllergicTo(Allergen.CATS)).isTrue();
    }

    @Test
    void notAllergic() {
        Allergies allergies = new Allergies(0);
        assertThat(allergies.getList()).isEmpty();
    }

    @Test
    void listJustEggs() {
        Allergies allergies = new Allergies(1);
        assertThat(allergies.getList())
                .containsExactly(Allergen.EGGS);
    }

    @Test
    void listJustPeanuts() {
        Allergies allergies = new Allergies(2);
        assertThat(allergies.getList())
                .containsExactly(Allergen.PEANUTS);
    }

    @Test
    void listJustStrawberries() {
        Allergies allergies = new Allergies(8);
        assertThat(allergies.getList())
                .containsExactly(Allergen.STRAWBERRIES);
    }

    @Test
    void listEggsAndPeanuts() {
        Allergies allergies = new Allergies(3);
        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.PEANUTS);
    }

    @Test
    void listMoreThanEggsButNotPeanuts() {
        Allergies allergies = new Allergies(5);
        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.SHELLFISH);
    }


    @Test
    void listManyAllergies() {
        Allergies allergies = new Allergies(248);
        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.STRAWBERRIES,
                        Allergen.TOMATOES,
                        Allergen.CHOCOLATE,
                        Allergen.POLLEN,
                        Allergen.CATS);
    }


    @Test
    void listEverything() {
        Allergies allergies = new Allergies(255);
        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.PEANUTS,
                        Allergen.SHELLFISH,
                        Allergen.STRAWBERRIES,
                        Allergen.TOMATOES,
                        Allergen.CHOCOLATE,
                        Allergen.POLLEN,
                        Allergen.CATS);
    }

    @Test
    void listNoAllergenScoreParts() {
        Allergies allergies = new Allergies(509);
        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.SHELLFISH,
                        Allergen.STRAWBERRIES,
                        Allergen.TOMATOES,
                        Allergen.CHOCOLATE,
                        Allergen.POLLEN,
                        Allergen.CATS);
    }

    @Test
    void listNoAllergenScorePartsWithoutHighestValidScore() {
        Allergies allergies = new Allergies(257);
        assertThat(allergies.getList())
                .containsExactly(Allergen.EGGS);
    }
}