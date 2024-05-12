package com.github.semouse.exercises.errorhandling;

public class CustomUncheckedException extends RuntimeException {
    CustomUncheckedException() {
        super();
    }

    CustomUncheckedException(String message) {
        super(message);
    }
}
