package com.github.semouse.bookingupforbeauty;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class AppointmentSchedulerTest {

    private final AppointmentScheduler scheduler = new AppointmentScheduler();

    @Test
    void schedule() {
        LocalDateTime appointment = scheduler.schedule("07/25/2019 13:45:00");
        assertEquals(LocalDateTime.of(2019, 7, 25, 13, 45, 0), appointment);
    }

    @Test
    void hasPassed() {
        boolean isPassed = scheduler.hasPassed(LocalDateTime.of(1999, 12, 31, 9, 0, 0));
        assertTrue(isPassed);
    }

    @Test
    void isAfternoonAppointment() {
        boolean afternoonAppointment = scheduler.isAfternoonAppointment(
            LocalDateTime.of(2019, 3, 29, 15, 0, 0));
        assertTrue(afternoonAppointment);
    }

    @Test
    void getDescription() {
        String description = scheduler.getDescription(LocalDateTime.of(2019, 3, 29, 15, 0, 0));
        assertEquals("You have an appointment on Friday, March 29, 2019, at 3:00 PM.", description);
    }

    @Test
    void getAnniversaryDate() {
        LocalDate anniversaryDate = scheduler.getAnniversaryDate();
        assertEquals(LocalDate.of(LocalDate.now().getYear(), 9, 15), anniversaryDate);
    }
}