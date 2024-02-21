package com.github.semouse.learning.salarycalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.semouse.learning.salarycalculator.SalaryCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SalaryCalculatorTest {

    private final SalaryCalculator calculator = new SalaryCalculator();

    @ParameterizedTest
    @CsvSource({"3, 1.0", "7, 0.85"})
    void salaryMultiplier(int daysSkipped, double expectedMultiplier) {
        double multiplier = calculator.salaryMultiplier(daysSkipped);
        assertEquals(expectedMultiplier, multiplier);
    }

    @ParameterizedTest
    @CsvSource({"21, 13", "5, 10"})
    void bonusMultiplier(int productSold, int expectedMultiplier) {
        int multiplier = calculator.bonusMultiplier(productSold);
        assertEquals(expectedMultiplier, multiplier);
    }

    @ParameterizedTest
    @CsvSource({"21, 273", "5, 50"})
    void bonusForProductsSold(int productSold, int expectedBonus) {
        double bonus = calculator.bonusForProductsSold(productSold);
        assertEquals(expectedBonus, bonus);
    }

    @ParameterizedTest
    @CsvSource({"2, 3, 1030.00", "0, 77, 2000.00"})
    void finalSalary(int daysSkipped, int productSold, double expectedSalary) {
        double salary = calculator.finalSalary(daysSkipped, productSold);
        assertEquals(expectedSalary, salary);
    }
}