package com.github.semouse.learning.logslogslogs;

public enum LogLevel {
    TRACE("TRC", 1),
    DEBUG("DBG", 2),
    INFO("INF", 4),
    WARNING("WRN", 5),
    ERROR("ERR", 6),
    FATAL("FTL", 42),
    UNKNOWN("", 0);

    private final String name;
    private final int number;

    LogLevel(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static LogLevel getByName(String name) {
        for (LogLevel level : LogLevel.values()) {
            if (level.name.equals(name)) {
                return level;
            }
        }

        return LogLevel.UNKNOWN;
    }
}
