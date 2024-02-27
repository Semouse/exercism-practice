package com.github.semouse.exercises.pangramchecker;

public class PangramChecker {

    public boolean isPangram(String input) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!input.toLowerCase().contains(String.valueOf(ch))) {
                return false;
            }
        }

        return true;
    }

}
