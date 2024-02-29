package com.github.semouse.exercises.raindrops;

import java.util.Map;

public class Raindrops {

    private static final Map<Integer, String> RAINDROP_SOUND = Map.of(3, "Pling", 5, "Plang", 7,
        "Plong");

    public String convert(int number) {
        return RAINDROP_SOUND.keySet().stream().sorted().filter(key -> number % key == 0)
            .map(RAINDROP_SOUND::get).reduce((s1, s2) -> s1 + s2).orElse(String.valueOf(number));
    }

}
