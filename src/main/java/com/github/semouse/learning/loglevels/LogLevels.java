package com.github.semouse.learning.loglevels;

public class LogLevels {

    private LogLevels() {
        throw new IllegalStateException("Utility class");
    }

    public static String message(String logLine) {
        return logLine.substring(logLine.indexOf(":") + 1).trim();
    }

    public static String logLevel(String logLine) {
        return logLine.substring(1, logLine.indexOf(":") - 1).toLowerCase();
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }

}
