package com.github.semouse.salarycalculator;

public class SalaryCalculator {

    private static final int BASE_SALARY = 1000;
    private static final int MAX_SALARY = 2000;

    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped >= 5 ? 0.85 : 1.0;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= 20 ? 13 : 10;
    }

    public double bonusForProductsSold(int productsSold) {
        return (double) bonusMultiplier(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double salary =
            BASE_SALARY * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);
        return salary > MAX_SALARY ? MAX_SALARY : salary;
    }
}
