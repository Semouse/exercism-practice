package com.github.semouse.exercises.highscores;

import java.util.Comparator;
import java.util.List;

public class HighScores {

    private final List<Integer> scores;

    public HighScores(List<Integer> highScores) {
        this.scores = highScores;
    }

    public List<Integer> scores() {
        return scores;
    }

    public Integer latest() {
        return scores.get(scores.size() - 1);
    }

    public Integer personalBest() {
        return scores.stream().max(Integer::compare).orElse(0);
    }

    public List<Integer> personalTopThree() {
        return scores.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
    }
}
