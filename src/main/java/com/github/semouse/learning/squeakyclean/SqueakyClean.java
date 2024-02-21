package com.github.semouse.learning.squeakyclean;

import java.util.Map;

/**
 * Tasks:
 * <p>
 * Implement the SqueakyClean.clean() method to replace any spaces with underscores. This also
 * applies to leading and trailing spaces.
 * <p>
 * Modify the SqueakyClean.clean() method to convert kebab-case to camelCase.
 * <p>
 * Modify the SqueakyClean.clean() method to convert leetspeak to normal text. For simplicity, we
 * will only be using 4, 3, 0, 1 and 7 from the table.
 * <p>
 * Modify the SqueakyClean.clean() method to omit any characters that are not letters and not
 * underscores.
 */
public class SqueakyClean {

    private final Map<Integer, Character> leetSpeakTable =
        Map.of(4, 'a', 3, 'e', 0, 'o', 1, 'l', 7, 't');

    public String clean(String identifier) {
        String result = replaceSpaceWithUnderscore(identifier);
        result = convertKebabCaseToCamelCase(result);
        result = convertLeetspeakToNormalText(result);
        result = omitNonLetterCharacters(result);
        return result;
    }

    private String replaceSpaceWithUnderscore(String str) {
        return str.replaceAll("\\s", "_");
    }

    private String convertKebabCaseToCamelCase(String str) {
        StringBuilder builder = new StringBuilder();
        boolean afterDash = false;
        for (Character c : str.toCharArray()) {
            if (c == '-') {
                afterDash = true;
            } else {
                builder.append(afterDash ? Character.toUpperCase(c) : c);
                afterDash = false;
            }
        }
        return builder.toString();
    }

    private String convertLeetspeakToNormalText(String str) {
        StringBuilder builder = new StringBuilder();
        for (Character c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                builder.append(leetSpeakTable.getOrDefault(Character.getNumericValue(c), c));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    private String omitNonLetterCharacters(String str) {
        StringBuilder builder = new StringBuilder();
        for (Character c : str.toCharArray()) {
            if (Character.isLetter(c) || c == '_') {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
