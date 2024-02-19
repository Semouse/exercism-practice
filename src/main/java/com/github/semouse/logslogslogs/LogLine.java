package com.github.semouse.logslogslogs;

public class LogLine {

    private final String line;

    public LogLine(String logLine) {
        this.line = logLine;
    }

    public LogLevel getLogLevel() {
        return LogLevel.getByName(parseLogName());
    }

    public String getOutputForShortLog() {
        return String.format("%d:%s", getLogLevel().getNumber(), message());
    }

    private String parseLogName() {
        return line.substring(1, line.indexOf(":") - 1);
    }

    private String message() {
        return line.substring(line.indexOf(":") + 1).trim();
    }
}
