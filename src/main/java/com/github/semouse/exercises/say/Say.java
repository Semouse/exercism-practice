package com.github.semouse.exercises.say;

import java.util.List;

/**
 * Given a number from 0 to 999,999,999,999, spell out that number in English.
 */
public class Say {

    private static final List<String> DIGITS = List.of("zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine");
    private static final List<String> TEENS = List.of("ten", "eleven", "twelve", "thirteen",
        "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");

    private static final List<String> TENS = List.of("twenty", "thirty", "forty", "fifty", "sixty",
        "seventy", "eighty", "ninety");

    public String say(long number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }

        String strNumber = String.valueOf(number);
        return switch (strNumber.length()) {
            case 1 -> parseDigits(number);
            case 2 -> parseTens(number);
            case 3 -> parseHundreds(number);
            case 4, 5, 6 -> parseThousands(number);
            case 7, 8, 9 -> parseMillions(number);
            case 10, 11, 12 -> parseBillions(number);
            default -> throw new IllegalArgumentException();
        };
    }

    private String parseBillions(long number) {
        String value = parseHundreds(number / 1_000_000_000);
        return value.isEmpty() ? parseMillions(number % 1_000_000_000)
            : String.join(" ", value, "billion",
                parseMillions(number % 1_000_000_000)).trim();
    }

    private String parseMillions(long number) {
        String value = parseHundreds(number / 1_000_000);
        return value.isEmpty() ? parseThousands(number % 1_000_000)
            : String.join(" ", value, "million",
                parseThousands(number % 1_000_000)).trim();
    }

    private String parseThousands(long number) {
        String value = parseHundreds(number / 1000);
        return value.isEmpty() ? parseHundreds(number % 1000)
            : String.join(" ", value, "thousand", parseHundreds(number % 1000)).trim();
    }

    private String parseHundreds(long number) {
        if (number < 100) {
            return parseTens(number);
        }
        return String.join(" ", parseDigits(number / 100), "hundred", parseTens(number % 100))
            .trim();
    }

    private String parseTens(long number) {
        if (number < 10) {
            String digit = parseDigits(number);
            return "zero".equals(digit) ? "" : digit;
        } else if (number < 20) {
            return parseTeens(number);
        } else {
            String tens = TENS.get((int) number / 10 - 2);
            return number % 10 == 0 ? tens : String.join("-", tens, parseDigits(number % 10));
        }
    }

    private String parseTeens(long number) {
        return TEENS.get((int) number - 10);
    }

    private String parseDigits(long number) {
        return DIGITS.get((int) number);
    }
}
