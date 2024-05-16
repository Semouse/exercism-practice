package com.github.semouse.exercises.triangle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class TriangleTest {
    @Test
    void equilateralTrianglesHaveEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(2, 2, 2);
        assertThat(triangle.isEquilateral()).isTrue();
    }

    @Test
    void trianglesWithOneUnequalSideAreNotEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(2, 3, 2);
        assertThat(triangle.isEquilateral()).isFalse();
    }

    @Test
    void trianglesWithNoEqualSidesAreNotEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(5, 4, 6);
        assertThat(triangle.isEquilateral()).isFalse();
    }

    @Test
    void trianglesWithNoSizeAreIllegal() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(0, 0, 0));
    }

    @Test
    void verySmallTrianglesCanBeEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.5, 0.5);
        assertThat(triangle.isEquilateral()).isTrue();
    }

    @Test
    void isoscelesTrianglesHaveLastTwoSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(3, 4, 4);
        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Test
    void isoscelesTrianglesHaveTwoFirstSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);
        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Test
    void isoscelesTrianglesHaveFirstAndLastSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 3, 4);
        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Test
    void equilateralTrianglesAreAlsoIsosceles() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 4);
        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Test
    void noSidesAreEqualCantBeIsoceles() throws TriangleException {
        Triangle triangle = new Triangle(2, 3, 4);
        assertThat(triangle.isIsosceles()).isFalse();
    }

    @Test
    void firstTriangleInequalityViolation() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(1, 1, 3));
    }

    @Test
    void secondTriangleInequalityViolation() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(1, 3, 1));
    }

    @Test
    void thirdTriangleInequalityViolation() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(3, 1, 1));
    }

    @Test
    void verySmallTrianglesCanBeIsosceles() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.4, 0.5);
        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Test
    void scaleneTrianglesHaveNoEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(5, 4, 6);
        assertThat(triangle.isScalene()).isTrue();
    }

    @Test
    void allSidesEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 4);
        assertThat(triangle.isScalene()).isFalse();
    }

    @Test
    void twoSidesEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);
        assertThat(triangle.isScalene()).isFalse();
    }

    @Test
    void firstAndThirdSidesAreEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(3, 4, 3);
        assertThat(triangle.isScalene()).isFalse();
    }

    @Test
    void secondAndThirdSidesAreEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(4, 3, 3);
        assertThat(triangle.isScalene()).isFalse();
    }

    @Test
    void mayNotViolateTriangleInequality() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(7, 3, 2));
    }

    @Test
    void verySmallTrianglesCanBeScalene() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.4, 0.6);
        assertThat(triangle.isScalene()).isTrue();
    }
}