package com.github.semouse.exercises.reversestring;

public class ReverseString {

    public String reverse(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }
}
