package com.github.semouse.exercises.isbn;

/**
 * <a href="https://exercism.org/tracks/java/exercises/isbn-verifier">...</a>
 */
public class IsbnVerifier {
    boolean isValid(String stringToVerify) {
        int sum = 0;
        int position = 0;
        for (char c : stringToVerify.toCharArray()){
            if(Character.isDigit(c)){
                sum += Character.getNumericValue(c) * (10 - position);
                position++;
            } else if (c == 'X' && position == 9) {
                sum += 10;
                position++;
            } else if (Character.isLetter(c)){
                return false;
            }
        }

        return position == 10 && sum % 11 == 0;
    }
}
