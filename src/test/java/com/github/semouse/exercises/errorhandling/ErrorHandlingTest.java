package com.github.semouse.exercises.errorhandling;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ErrorHandlingTest {
    private final ErrorHandling errorHandling = new ErrorHandling();

    @Test
    void testThrowIllegalArgumentException() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(errorHandling::handleErrorByThrowingIllegalArgumentException);
    }

    @Test
    void testThrowIllegalArgumentExceptionWithDetailMessage() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage("This is the detail message."))
                .withMessage("This is the detail message.");
    }

    @Test
    void testThrowAnyCheckedException() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(errorHandling::handleErrorByThrowingAnyCheckedException)
                .isNotInstanceOf(RuntimeException.class);
    }

    @Test
    void testThrowAnyCheckedExceptionWithDetailMessage() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingAnyCheckedExceptionWithDetailMessage("This is the detail message."))
                .isNotInstanceOf(RuntimeException.class)
                .withMessage("This is the detail message.");
    }

    @Test
    void testThrowAnyUncheckedException() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(errorHandling::handleErrorByThrowingAnyUncheckedException);
    }

    @Test
    void testThrowAnyUncheckedExceptionWithDetailMessage() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage("This is the detail message."))
                .withMessage("This is the detail message.");
    }

    @Test
    void testThrowCustomCheckedException() {
        assertThatExceptionOfType(CustomCheckedException.class)
                .isThrownBy(errorHandling::handleErrorByThrowingCustomCheckedException);
    }

    @Test
    void testThrowCustomCheckedExceptionWithDetailMessage() {
        assertThatExceptionOfType(CustomCheckedException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingCustomCheckedExceptionWithDetailMessage("This is the detail message."))
                .withMessage("This is the detail message.");
    }

    @Test
    void testThrowCustomUncheckedException() {
        assertThatExceptionOfType(CustomUncheckedException.class)
                .isThrownBy(errorHandling::handleErrorByThrowingCustomUncheckedException);
    }

    @Test
    void testThrowCustomUncheckedExceptionWithDetailMessage() {
        assertThatExceptionOfType(CustomUncheckedException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage("This is the detail message."))
                .withMessage("This is the detail message.");
    }

    @Test
    void testReturnOptionalInstance() {
        Optional<Integer> successfulResult = errorHandling.handleErrorByReturningOptionalInstance("1");
        assertThat(successfulResult).isPresent().hasValue(1);
        Optional<Integer> failureResult = errorHandling.handleErrorByReturningOptionalInstance("a");
        assertThat(failureResult).isNotPresent();
    }
}