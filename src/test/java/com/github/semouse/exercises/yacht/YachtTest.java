package com.github.semouse.exercises.yacht;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YachtTest {

    @Test
    void yacht() {
        Yacht yacht = new Yacht(new int[]{5, 5, 5, 5, 5}, YachtCategory.YACHT);
        assertThat(yacht.score()).isEqualTo(50);
    }

    @Test
    void notYacht() {
        Yacht yacht = new Yacht(new int[]{1, 3, 3, 2, 5}, YachtCategory.YACHT);
        assertThat(yacht.score()).isZero();
    }

    @Test
    void ones() {
        Yacht yacht = new Yacht(new int[]{1, 1, 1, 3, 5}, YachtCategory.ONES);
        assertThat(yacht.score()).isEqualTo(3);
    }

    @Test
    void onesOutOfOrder() {
        Yacht yacht = new Yacht(new int[]{3, 1, 1, 5, 1}, YachtCategory.ONES);
        assertThat(yacht.score()).isEqualTo(3);
    }

    @Test
    void noOnes() {
        Yacht yacht = new Yacht(new int[]{4, 3, 6, 5, 5}, YachtCategory.ONES);
        assertThat(yacht.score()).isZero();
    }


    @Test
    void twos() {
        Yacht yacht = new Yacht(new int[]{2, 3, 4, 5, 6}, YachtCategory.TWOS);
        assertThat(yacht.score()).isEqualTo(2);
    }

    @Test
    void yachtCountedAsThrees() {
        Yacht yacht = new Yacht(new int[]{3, 3, 3, 3, 3}, YachtCategory.THREES);
        assertThat(yacht.score()).isEqualTo(15);
    }

    @Test
    void fours() {
        Yacht yacht = new Yacht(new int[]{1, 4, 1, 4, 1}, YachtCategory.FOURS);
        assertThat(yacht.score()).isEqualTo(8);
    }

    @Test
    void yachtOfThreesCountedAsFives() {
        Yacht yacht = new Yacht(new int[]{3, 3, 3, 3, 3}, YachtCategory.FIVES);
        assertThat(yacht.score()).isZero();
    }

    
    @Test
    void fives() {
        Yacht yacht = new Yacht(new int[]{1, 5, 3, 5, 3}, YachtCategory.FIVES);
        assertThat(yacht.score()).isEqualTo(10);
    }

    
    @Test
    void sixes() {
        Yacht yacht = new Yacht(new int[]{2, 3, 4, 5, 6}, YachtCategory.SIXES);
        assertThat(yacht.score()).isEqualTo(6);
    }


    @Test
    void fullHouseTwoSmallThreeBig() {
        Yacht yacht = new Yacht(new int[]{2, 2, 4, 4, 4}, YachtCategory.FULL_HOUSE);
        assertThat(yacht.score()).isEqualTo(16);
    }

    
    @Test
    void fullHouseThreeSmallTwoBig() {
        Yacht yacht = new Yacht(new int[]{5, 3, 3, 5, 3}, YachtCategory.FULL_HOUSE);
        assertThat(yacht.score()).isEqualTo(19);
    }

    
    @Test
    void twoPairIsNotAFullHouse() {
        Yacht yacht = new Yacht(new int[]{2, 2, 4, 4, 5}, YachtCategory.FULL_HOUSE);
        assertThat(yacht.score()).isZero();
    }

    
    @Test
    void fourOfAKindIsNotAFullHouse() {
        Yacht yacht = new Yacht(new int[]{1, 4, 4, 4, 4}, YachtCategory.FULL_HOUSE);
        assertThat(yacht.score()).isZero();
    }

    
    @Test
    void yachtIsNotAFullHouse() {
        Yacht yacht = new Yacht(new int[]{2, 2, 2, 2, 2}, YachtCategory.FULL_HOUSE);
        assertThat(yacht.score()).isZero();
    }


    @Test
    void fourOfAKind() {
        Yacht yacht = new Yacht(new int[]{6, 6, 4, 6, 6}, YachtCategory.FOUR_OF_A_KIND);
        assertThat(yacht.score()).isEqualTo(24);
    }

    
    @Test
    void yachtCanBeScoredAsFourOfAKind() {
        Yacht yacht = new Yacht(new int[]{3, 3, 3, 3, 3}, YachtCategory.FOUR_OF_A_KIND);
        assertThat(yacht.score()).isEqualTo(12);
    }

    
    @Test
    void fullHouseIsNotFourOfAKind() {
        Yacht yacht = new Yacht(new int[]{3, 3, 3, 5, 5}, YachtCategory.FOUR_OF_A_KIND);
        assertThat(yacht.score()).isZero();
    }

    
    @Test
    void littleStraight() {
        Yacht yacht = new Yacht(new int[]{3, 5, 4, 1, 2}, YachtCategory.LITTLE_STRAIGHT);
        assertThat(yacht.score()).isEqualTo(30);
    }
    
    @Test
    void fourInOrderButNotALittleStraight() {
        Yacht yacht = new Yacht(new int[]{1, 1, 2, 3, 4}, YachtCategory.LITTLE_STRAIGHT);
        assertThat(yacht.score()).isZero();
    }

    
    @Test
    void noPairsButNotALittleStraight() {
        Yacht yacht = new Yacht(new int[]{1, 2, 3, 4, 6}, YachtCategory.LITTLE_STRAIGHT);
        assertThat(yacht.score()).isZero();
    }

    
    @Test
    void minimumIs1MaximumIs5ButNotALittleStraight() {
        Yacht yacht = new Yacht(new int[]{1, 1, 3, 4, 5}, YachtCategory.LITTLE_STRAIGHT);
        assertThat(yacht.score()).isZero();
    }

    @Test
    void bigStraightAsLittleStraight() {
        Yacht yacht = new Yacht(new int[]{6, 5, 4, 3, 2}, YachtCategory.LITTLE_STRAIGHT);
        assertThat(yacht.score()).isZero();
    }
    
    @Test
    void bigStraight() {
        Yacht yacht = new Yacht(new int[]{4, 6, 2, 5, 3}, YachtCategory.BIG_STRAIGHT);
        assertThat(yacht.score()).isEqualTo(30);
    }

    @Test
    void littleStraightAsBigStraight() {
        Yacht yacht = new Yacht(new int[]{1, 2, 3, 4, 5}, YachtCategory.BIG_STRAIGHT);
        assertThat(yacht.score()).isZero();
    }
    
    @Test
    void noPairsButNotABigStraight() {
        Yacht yacht = new Yacht(new int[]{6, 5, 4, 3, 1}, YachtCategory.BIG_STRAIGHT);
        assertThat(yacht.score()).isZero();
    }

    
    @Test
    void choice() {
        Yacht yacht = new Yacht(new int[]{3, 3, 5, 6, 6}, YachtCategory.CHOICE);
        assertThat(yacht.score()).isEqualTo(23);
    }

    
    @Test
    void yachtAsChoice() {
        Yacht yacht = new Yacht(new int[]{2, 2, 2, 2, 2}, YachtCategory.CHOICE);
        assertThat(yacht.score()).isEqualTo(10);
    }
}