package com.github.semouse.exercises.gigasecond;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private static final long INTERVAL = 1_000_000_000;
    private final LocalDateTime dateTime;

    public Gigasecond(LocalDate moment) {
        this.dateTime = moment.atStartOfDay().plus(INTERVAL, SECONDS);
    }

    public Gigasecond(LocalDateTime moment) {
        this.dateTime = moment.plus(INTERVAL, SECONDS);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
