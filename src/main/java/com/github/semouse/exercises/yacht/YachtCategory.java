package com.github.semouse.exercises.yacht;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public enum YachtCategory {
    YACHT {
        @Override
        public int score(int[] dices) {
            return stream(dices).distinct().count() <= 1 ? 50 : 0;
        }
    },
    ONES {
        @Override
        public int score(int[] dices) {
            return Math.toIntExact(stream(dices).filter(dice -> dice == 1).count());
        }
    }, TWOS {
        @Override
        public int score(int[] dices) {
            return Math.toIntExact(stream(dices).filter(dice -> dice == 2).count() * 2);
        }
    }, THREES {
        @Override
        public int score(int[] dices) {
            return Math.toIntExact(stream(dices).filter(dice -> dice == 3).count() * 3);
        }
    }, FOURS {
        @Override
        public int score(int[] dices) {
            return Math.toIntExact(stream(dices).filter(dice -> dice == 4).count() * 4);
        }
    }, FIVES {
        @Override
        public int score(int[] dices) {
            return Math.toIntExact(stream(dices).filter(dice -> dice == 5).count() * 5);
        }
    }, SIXES {
        @Override
        public int score(int[] dices) {
            return Math.toIntExact(stream(dices).filter(dice -> dice == 6).count() * 6);
        }
    }, FULL_HOUSE {
        @Override
        public int score(int[] dices) {
            Map<Integer, Integer> occurrences = stream(dices).boxed()
                    .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));

            if (occurrences.size() != 2 || occurrences.values().stream().anyMatch(i -> i < 2)) {
                return 0;
            } else {
                return stream(dices).sum();
            }
        }
    }, FOUR_OF_A_KIND {
        @Override
        public int score(int[] dices) {
            Map<Integer, Integer> occurrences = stream(dices).boxed()
                    .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));

            if (occurrences.values().stream().anyMatch(i -> i >= 4)) {
                return 4 * Collections.max(occurrences.entrySet(), Map.Entry.comparingByValue()).getKey();
            } else {
                return 0;
            }
        }
    }, LITTLE_STRAIGHT {
        @Override
        public int score(int[] dices) {
            Arrays.sort(dices);

            for (int i = 0; i < dices.length - 1; i++) {
                if (dices[0] != 1 || dices[i] != dices[i + 1] - 1) {
                    return 0;
                }
            }

            return 30;
        }
    }, BIG_STRAIGHT {
        @Override
        public int score(int[] dices) {
            Arrays.sort(dices);

            for (int i = dices.length - 1; i > 0; i--) {
                if (dices[dices.length - 1] != 6 || dices[i] != dices[i - 1] + 1) {
                    return 0;
                }
            }

            return 30;
        }
    }, CHOICE {
        @Override
        public int score(int[] dices) {
            return stream(dices).sum();
        }
    };

    public abstract int score(int[] dices);
}
