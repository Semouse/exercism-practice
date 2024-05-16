package com.github.semouse.exercises.triangle;

/**
 * <a href="https://exercism.org/tracks/java/exercises/triangle">Source</a>
 */
public class Triangle {

    private final double a;
    private final double b;
    private final double c;

    Triangle(double a, double b, double c) throws TriangleException {
        if(a == 0 || b == 0 || c == 0){
            throw new TriangleException();
        }

        if (a + b >= c && a + c >= b && b + c >= a) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new TriangleException();
        }
    }

    boolean isEquilateral() {
       return a == b && b == c;
    }

    boolean isIsosceles() {
        return a == b || b == c || a == c;
    }

    boolean isScalene() {
        return a != b && b != c && a != c;
    }

}
