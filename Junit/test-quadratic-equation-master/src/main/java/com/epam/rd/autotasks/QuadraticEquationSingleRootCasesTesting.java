package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadraticEquationSingleRootCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 1, -1",    // discriminant == 0
            "4, 4, 1, -0.5",  // discriminant == 0
            "9, 12, 4, -0.6666666666666666", // discriminant == 0
            "16, 8, 1, -0.25" // discriminant == 0
    })
    public void testCase(double a, double b, double c, double expected) {
        assertEquals(String.valueOf(expected), quadraticEquation.solve(a, b, c));
    }
}
