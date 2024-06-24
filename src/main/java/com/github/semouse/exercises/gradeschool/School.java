package com.github.semouse.exercises.gradeschool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {

    private final Map<String, Integer> roster;

    public School() {
        this.roster = new HashMap<>();
    }

    boolean add(String student, int grade) {
        Integer value = roster.putIfAbsent(student, grade);
        return value == null;
    }

    List<String> roster() {
        return roster.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .toList();
    }

    List<String> grade(int grade) {
        return roster.entrySet().stream()
                .filter(entry -> entry.getValue().equals(grade))
                .map(Map.Entry::getKey)
                .sorted(String::compareTo)
                .toList();
    }
}
