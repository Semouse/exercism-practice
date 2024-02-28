package com.github.semouse.exercises.eliudseggs;

public class EliudsEggs {

    public int eggCount(int number) {
        return (int) Integer.toBinaryString(number).chars().filter(i -> i == '1').count();
    }
}
