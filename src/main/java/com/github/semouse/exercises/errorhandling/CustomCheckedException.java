package com.github.semouse.exercises.errorhandling;

public class CustomCheckedException extends Exception {

    CustomCheckedException() {
        super();
    }

    CustomCheckedException(String message) {
        super(message);
    }
}
