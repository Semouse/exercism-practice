package com.github.semouse.exercises.prime;


/**
 * <a href="https://exercism.org/tracks/java/exercises/nth-prime">...</a>
 */
public class PrimeCalculator {
    int nth(int nth) {
        if (nth <= 0) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        int value = 1;
        while (count != nth) {
            value++;
            if (isPrime(value)) {
                count++;
            }
        }

        return value;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
