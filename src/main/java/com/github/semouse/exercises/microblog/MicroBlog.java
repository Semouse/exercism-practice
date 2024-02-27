package com.github.semouse.exercises.microblog;

public class MicroBlog {

    private static final int INPUT_LIMIT = 5;

    public String truncate(String input) {
        return input.codePointCount(0, input.length()) <= INPUT_LIMIT ? input :
            input.codePoints().limit(INPUT_LIMIT)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
